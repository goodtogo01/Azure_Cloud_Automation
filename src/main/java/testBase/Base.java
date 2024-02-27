package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {
    WebDriver driver;

    @Parameters("browser")
    public void setup() {
    	String browser = null;
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
//            DesiredCapabilities cap = new DesiredCapabilities();
//            cap.setCapability("browserName", "chrome");
//            try {
//                driver = new RemoteWebDriver(new URL("http://13.11.111.11"), cap);
//            } catch (MalformedURLException e) {
//                throw new RuntimeException(e);
//            }
        } else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
//            DesiredCapabilities cap = new DesiredCapabilities();
//            cap.setCapability("browserName", "firefox");
//            try {
//                driver = new RemoteWebDriver(new URL("http://13.11.111.11"), cap);
//            } catch (MalformedURLException e) {
//                throw new RuntimeException(e);
//            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.freshworks.com/");
    }
}
