package selenium_docker_integration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class YahooPage {

    @Test
    public void getYahooPageTitle() throws MalformedURLException {
        //Create URL object and pass Docker port url
        URL url = new URL("http://localhost:4444/wd/hub");

        //Create Desired capabilities to run Chrome instance
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        //Create Remote WebDriver object to run in Docker
        RemoteWebDriver driver = new RemoteWebDriver(url, capabilities);

        driver.get("https://espanol.yahoo.com/?p=us");
        driver.getTitle();

    }
}
