package eu.gr8conf.workshop.modules

import geb.Module


class QuoteModule extends Module {

    static content = {
        text { $("div.quoteText").text() }
        authorAndTitle { $("a.authorOrTitle", it) }
        author { authorAndTitle(0)?.text() }
        title(required: false) { authorAndTitle(1)?.text() }
    }

}