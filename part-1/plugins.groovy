#!/usr/bin/env groovy

@Grapes([
        @Grab("org.gebish:geb-core:1.1.1"),
        @Grab("org.seleniumhq.selenium:selenium-firefox-driver:3.4.0"),
        @Grab("io.github.bonigarcia:webdrivermanager:1.6.2"),
])


import io.github.bonigarcia.wdm.FirefoxDriverManager
import org.openqa.selenium.firefox.FirefoxDriver
import geb.Browser

FirefoxDriverManager.instance.setup()
Browser browser = new Browser(driver: new FirefoxDriver())


browser.with {

    go "http://plugins.grails.org/q/sort%3Adate"

    sleep(3000)

    Map publishers = [:]

    def plugins = $("ul.plugins-list li")

    plugins.each { plugin ->
        def pluginLink  = plugin.find("a.plugin-name").attr('href')
        def pluginTitle = plugin.find("a.plugin-name").text()?.trim()
        def description = plugin.find("span.plugin-description").text()?.trim()
        def pluginVersion = plugin.find("div.bintray-section").text()?.trim()
        def version = pluginVersion?.takeWhile { c -> c != ' ' }
        def lastUpdated = pluginVersion?.dropWhile { c -> c != ' ' }

        String publisher = plugin.find("span.owner").text()?.trim()


        if( publishers[publisher] ) {
            publishers[publisher] = publishers[publisher] + 1
        } else {
            publishers[publisher] = 1
        }

        println """<li><!-- ${lastUpdated} --><a href="${pluginLink}" target="_blank">${pluginTitle}</a> (${version}) ${description}.</li>"""
    }

    publishers.each { k,v ->
        println "${k} -> ${v}"

    }
}

browser.close()