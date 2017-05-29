package eu.gr8conf.workshop

import geb.spock.GebReportingSpec
import spock.lang.Unroll

class JsAlertsSpec extends GebReportingSpec {



    void "verify javascript alert can be handled"() {
        setup:
        go "http://the-internet.herokuapp.com/javascript_alerts"

        when:
        withAlert {
            $("li>button", 0).click()
        }

        then:
        $("#result").text() == "You successfuly clicked an alert"
    }

    @Unroll
    void "verify javascript confirm can be handled - accepting and rejecting"() {
        setup:
        go "http://the-internet.herokuapp.com/javascript_alerts"

        when:
        withConfirm(accepting) {
            $("li>button", 1).click()
        }

        then:
        $("#result").text() == message

        where:
        accepting   | message
        true        | "You clicked: Ok"
        false       | "You clicked: Cancel"

    }



}