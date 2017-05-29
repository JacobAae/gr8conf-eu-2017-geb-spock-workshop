package eu.gr8conf.workshop

import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class LoginLogoutSpec extends GebReportingSpec {

    void "login with wrong credential gives error message"() {
        setup:
        go "http://the-internet.herokuapp.com/login"

        when:
        $("form").username = "unknown"
        $("form").password = "wrong"

        and:
        $("button.radius").click()

        then:
        waitFor {
            $("#flash").text().contains  "Your username is invalid!"
        }
    }

    void "login with correct credentials gives access"() {
        when:
        $("form").username = "tomsmith"
        $("form").password = "SuperSecretPassword!"

        and:
        $("button.radius").click()

        then:
        waitFor {
            $("h2").text() == "Secure Area"
        }
        currentUrl == "http://the-internet.herokuapp.com/secure"
        $("#flash").text().contains "You logged into a secure area!"

    }

    void "logout brings you back to login page"() {
        when:
        $("a.button").click()

        then:
        waitFor {
            $("#flash").text().contains "You logged out of the secure area!"
        }

    }

    void "acces to secure area is not allowed after logout"() {
        when:
        go "http://the-internet.herokuapp.com/secure"

        then:
        waitFor {
            $("#flash").text().contains "You must login to view the secure area!"
        }
        currentUrl == "http://the-internet.herokuapp.com/login"
    }


}