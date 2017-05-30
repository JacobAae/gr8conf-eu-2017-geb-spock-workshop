package eu.gr8conf.workshop.pages

import eu.gr8conf.workshop.modules.QuoteModule
import eu.gr8conf.workshop.modules.SearchFormModule
import geb.Page


class QuotesSearchResultsPage extends Page {

    static at = {
        $("h1").text() == "Find Quotes"
    }

    static content = {
        authorSearchForm { $("form.searchBox").module(SearchFormModule) }
        tagsSearchForm { $("form.popularTagSearch").module(SearchFormModule) }
        quotes { $("div.quote").moduleList(QuoteModule) }
    }
}
