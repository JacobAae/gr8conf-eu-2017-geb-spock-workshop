package eu.gr8conf.workshop.modules

import geb.Module

class SearchFormModule extends Module {

    static content = {
        searchField { $("input", type: "text") }
        submitButton { $("input", type: "submit") }
    }

}
