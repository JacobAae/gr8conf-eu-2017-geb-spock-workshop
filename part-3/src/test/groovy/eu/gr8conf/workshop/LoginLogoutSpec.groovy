package eu.gr8conf.workshop

import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class LoginLogoutSpec extends GebReportingSpec {

    void "login with wrong credential gives error message"() {
        setup:
        go "http://the-internet.herokuapp.com/login"

        expect: 'Needs implementation'
        false
    }

    void "login with correct credentials gives access"() {
        expect: 'Needs implementation'
        false
    }

    void "logout brings you back to login page"() {
        expect: 'Needs implementation'
        false
    }

    void "acces to secure area is not allowed after logout"() {
        expect: 'Needs implementation'
        false
    }

}