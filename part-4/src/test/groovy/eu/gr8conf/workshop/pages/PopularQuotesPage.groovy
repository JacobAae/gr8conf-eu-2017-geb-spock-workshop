package eu.gr8conf.workshop.pages

import eu.gr8conf.workshop.modules.SearchFormModule
import geb.Page


class PopularQuotesPage extends Page {

    static url = "/quotes"

    static at = {
        title == "Popular Quotes"
    }

    static content = {
        authorSearchForm { $("form.searchBox").module(SearchFormModule) }
        tagsSearchForm { $("form.popularTagSearch").module(SearchFormModule) }
    }
}
