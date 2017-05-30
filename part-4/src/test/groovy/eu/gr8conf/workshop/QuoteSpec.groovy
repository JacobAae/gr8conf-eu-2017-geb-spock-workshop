package eu.gr8conf.workshop

import eu.gr8conf.workshop.pages.PopularQuotesPage
import eu.gr8conf.workshop.pages.QuotesSearchResultsPage
import eu.gr8conf.workshop.pages.QuotesTagResultsPage
import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class QuoteSpec extends GebReportingSpec {

    void "go to popular quotes page and verify we are there"() {
        setup:
        PopularQuotesPage popularQuotesPage = to PopularQuotesPage

        expect:
        at PopularQuotesPage
    }

    void "search for author Douglas Adams brings forward quotes of him"() {
        setup:
        PopularQuotesPage popularQuotesPage = to PopularQuotesPage

        when:
        popularQuotesPage.authorSearchForm.searchField = "Douglas Adams"

        and:
        popularQuotesPage.authorSearchForm.submitButton.click()

        then:
        at QuotesSearchResultsPage
        // TODO Verify quotes all by Douglas Adams
        // Quote module
    }

    void "Searching for tag 'computer-viruses' brings quotes by Hawkins and Mariotti"() {
        setup:
        PopularQuotesPage popularQuotesPage = to PopularQuotesPage

        when:
        popularQuotesPage.tagsSearchForm.searchField = "computer-viruses"

        and:
        popularQuotesPage.tagsSearchForm.submitButton.click()

        then:
        QuotesTagResultsPage quotesTagResultsPage = at QuotesTagResultsPage
        quotes*.author.every { it in ['Stephen Hawking', 'John Mariotti'] }
    }

    void "searching for tag 'nerd' the pagination works to navigate"() {
        setup:
        PopularQuotesPage popularQuotesPage = to PopularQuotesPage

        when:
        popularQuotesPage.tagsSearchForm.searchField = "nerd"

        and:
        popularQuotesPage.tagsSearchForm.submitButton.click()

        then:
        QuotesTagResultsPage quotesTagResultsPage = at QuotesTagResultsPage

        when:
        quotesTagResultsPage.nextPage.click()

        then:
        at QuotesTagResultsPage
        quotesTagResultsPage.paginationInfo == "(showing 31-60 of 82)"
    }
}