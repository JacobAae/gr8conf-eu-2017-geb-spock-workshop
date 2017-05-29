import io.github.bonigarcia.wdm.ChromeDriverManager
import io.github.bonigarcia.wdm.FirefoxDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.firefox.FirefoxDriver

driver = {

    def driverInstance

    def useChrome = true
    if( useChrome ) {
        ChromeDriverManager.getInstance().setup()
        driverInstance = new ChromeDriver()
    } else {
        FirefoxDriverManager.getInstance().setup()
        FirefoxProfile profile = new FirefoxProfile()
        profile.setPreference("browser.download.folderList", 2)
        profile.setPreference("browser.download.dir", "/tmp")
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv")

        driverInstance = new FirefoxDriver(profile)
    }

    driverInstance.manage().window().maximize()
    driverInstance

}

baseUrl = "http://the-internet.herokuapp.com/"
reportsDir = new File("build/geb-reports")

waiting {
    timeout = 15
    retryInterval = 0.5
    includeCauseInMessage = true
}

atCheckWaiting = true
baseNavigatorWaiting = true
reportOnTestFailureOnly = true
