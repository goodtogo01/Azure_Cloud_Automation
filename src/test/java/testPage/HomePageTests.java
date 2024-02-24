package testPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testBase.Base;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HomePageTests extends Base {
    WebDriver driver;
    Base base = new Base();

    @Parameters("browser")
    @BeforeMethod
    public void initialization(String browser) {
        base.setup(browser);
    }

    @Test
    public void logoTest() {
        boolean flag = false;
        flag = driver.findElement(By.xpath("//*[@id='__next']/header/nav/div[1]/div/a")).isDisplayed();
        Assert.assertTrue(flag, "Element not displayed");
    }

    @Test
    public void titleTest() {
        String pageTitle = driver.getTitle();
        System.out.println("Page Title is : " + pageTitle);
        assertEquals(pageTitle, "Innovative Software for Business Needs | Freshworks", "Title didnt match");
    }
    @Test
    public void footerManue(){
        List<WebElement> fmanue = driver.findElements(By.xpath("//*[@id=\"__next\"]/footer/div/div[4]/ul"));
        fmanue.forEach(e->System.out.println(e.getText()));
        assertEquals(fmanue.size(), 1, "Size of list is not match");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}
