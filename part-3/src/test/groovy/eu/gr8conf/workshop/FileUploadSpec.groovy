package eu.gr8conf.workshop

import geb.spock.GebReportingSpec

class FileUploadSpec extends GebReportingSpec {

    void "uploading a file shows the filename after succesfull upload"() {
        setup:
        go "http://the-internet.herokuapp.com/upload"

        expect: 'Needs implementation'
        false
    }

    void "filedownload retrieves a file"() {
        setup:
        go "http://the-internet.herokuapp.com/download"

        expect: 'Needs implementation'
        false
    }

    /*
        Helper method to retrieve a file location for the DummyFile.txt in the classpath
     */
    String getDummyFilePath() {
        getClass().classLoader.getResource('DummyFile.txt').file
    }

}