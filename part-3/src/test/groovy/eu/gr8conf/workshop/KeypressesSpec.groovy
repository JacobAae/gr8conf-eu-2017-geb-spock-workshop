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

    @Unroll
    void "keypresses are registrered"() {
        setup:
        go "http://the-internet.herokuapp.com/key_presses"

        when:
        $("body") << input


        then:
        $("#result").text() == text

        where:
        input                       | text
        Keys.chord(Keys.SPACE)      | "You entered: SPACE"
        Keys.chord(Keys.ARROW_UP)   | "You entered: UP"
        'A'                         | "You entered: A"

    }
}