package eu.gr8conf.workshop

import geb.spock.GebReportingSpec


class BasicAuthSpec extends GebReportingSpec {

    void "logging in with basic auth gives message: 'Congratulations! You must have the proper credentials.'"() {
        when:
        go "http://admin:admin@the-internet.herokuapp.com/basic_auth"

        then:
        $("p").text().trim() == "Congratulations! You must have the proper credentials."
    }
}