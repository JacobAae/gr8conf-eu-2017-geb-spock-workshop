package eu.gr8conf.workshop

import eu.gr8conf.workshop.pages.PopularQuotesPage
import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class QuoteSpec extends GebReportingSpec {

    void "go to popular quotes page and verify we are there"() {
        setup:
        PopularQuotesPage page = to PopularQuotesPage

        expect:
        at PopularQuotesPage
    }

    void "search for author Douglas Adams brings forward quotes of him"() {
        expect: 'Needs implementation'
        false
    }

    void "Searching for tag 'computer-viruses' brings quotes by Hawkins and Mariotti"() {
        expect: 'Needs implementation'
        false
    }

    void "searching for tag nerd the pagination works to navigate"() {
        expect: 'Needs implementation'
        false
    }


}