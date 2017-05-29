package eu.gr8conf.workshop

import geb.spock.GebReportingSpec


class FileUploadSpec extends GebReportingSpec {

    void "uploading a file shows the filename"() {
        setup:
        go "http://the-internet.herokuapp.com/upload"

        when:
        $("form").file = getDummyFilePath()
        $("input.button").click()

        then:
        waitFor{
            $("#uploaded-files").text().trim() == "DummyFile.txt"
        }
    }

    void "filedownload retrieves a file"() {
        setup:
        go "http://the-internet.herokuapp.com/download"

        when:
        def downloadLink = $("a", text: 'DummyFile.txt')

        and:
        def bytes = downloadBytes(downloadLink.@href)

        then:
        new String(bytes) == "No fun here!"
    }

    String getDummyFilePath() {
        getClass().classLoader.getResource('DummyFile.txt').file
    }

}