package eu.gr8conf.workshop.pages

import eu.gr8conf.workshop.modules.QuoteModule
import eu.gr8conf.workshop.modules.SearchFormModule
import geb.Page


class QuotesTagResultsPage extends Page {

    static at = {
        $("h1").text()?.startsWith("Quotes About ")
    }

    static content = {
        authorSearchForm { $("form.searchBox").module(SearchFormModule) }
        tagsSearchForm { $("form.popularTagSearch").module(SearchFormModule) }
        quotes { $("div.quote").moduleList(QuoteModule) }
        nextPage(required: false) { $("a.next_page") }
        paginationInfo(required: false) { $("span.smallText").first().text() }
    }
}
