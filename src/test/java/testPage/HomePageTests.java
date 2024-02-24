package testPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testBase.Base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class HomePageTests extends Base {
	WebDriver driver;
	Base base = new Base();

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//                DesiredCapabilities cap = new DesiredCapabilities();
//                cap.setCapability("browserName", "chrome");
//                try {
//                    driver = new RemoteWebDriver(new URL("http://13.11.111.11"), cap);
//                } catch (MalformedURLException e) {
//                    throw new RuntimeException(e);
//                }
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
//                DesiredCapabilities cap = new DesiredCapabilities();
//                cap.setCapability("browserName", "firefox");
//                try {
//                    driver = new RemoteWebDriver(new URL("http://13.11.111.11"), cap);
//                } catch (MalformedURLException e) {
//                    throw new RuntimeException(e);
//                }
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.freshworks.com/");
		//driver.switchTo().alert().accept();
	}

	@Test(priority = 1)
	public void logoTest() {
		boolean flag = false;
		flag = driver.findElement(By.xpath("//*[@id='__next']/header/nav/div[1]/div/a")).isDisplayed();
		Assert.assertTrue(flag, "Element not displayed");
		System.out.println("Logo found......");
	}

	@Test(priority = 2)
	public void titleTest() {
		String pageTitle = driver.getTitle();
		System.out.println("\nPage Title is.................: " + pageTitle);
		assertEquals(pageTitle, "Innovative Software for Business Needs | Freshworks", "Title didnt match");
	}

	@Test(priority = 3)
	public void footerManue() {
		List<WebElement> fmanue = driver.findElements(By.xpath("//*[@id='__next']/footer/div/div[4]/ul"));
		System.out.println("\nFooter Items found as : ......................");
		fmanue.forEach(e -> System.out.println(e.getText()));
		assertEquals(fmanue.size(), 1, "Size of list is not match");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
