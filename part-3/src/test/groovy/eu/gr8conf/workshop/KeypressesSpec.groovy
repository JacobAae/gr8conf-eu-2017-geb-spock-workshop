package eu.gr8conf.workshop

import geb.spock.GebReportingSpec
import org.openqa.selenium.Keys
import spock.lang.Unroll


/**
 * Run command line using
 *
 * .gradlew test -Dtest.single=KeypressesSpec
 */
class KeypressesSpec extends GebReportingSpec {

    // Test A, UP-key and Space
    @Unroll
    void "keypresses are registrered"() {
        setup:
        go "http://the-internet.herokuapp.com/key_presses"

        expect: 'Needs implementation'
        false
    }
}