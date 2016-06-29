/**
 * Created by Justin on 6/27/16.
 */

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.*;

public class TestWorld {

/** http://seleniumhq.org **/
    @Test
    public void testLogin() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/res/webdriver/chromedriver");

        // Set up WebDriver for a local Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Browse to specified URL
        driver.get( "https://www.yahoo.com/" );

        // Submit the form
        driver.findElement( By.id("uh-search-box")).sendKeys("Test search");

        // Enter the username into the Login field
        driver.findElement( By.id( "uh-search-button" )).click();

//        // Browse to specified URL
//        driver.get( "https://asp-stage.testschoolmessenger.com/Applehaus" );
//
//        // Enter the username into the Login field
//        driver.findElement( By.id( "form_login" )).sendKeys( "cKane" );
//
//        // Enter the password into the Password field
//        driver.findElement( By.xpath( "//input[@type='password']" )).sendKeys( "r0seBud" );
//
//        // Submit the form
//        driver.findElement( By.name( "Submit" )).click();

        // Output title of resulting page.
        System.out.println( driver.getTitle() );

    }
    @Test
    public void orderChipotle(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/res/webdriver/chromedriver");

        WebDriver driver = new ChromeDriver();

//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='findAddressSubmit']/input"))).sendKeys("95064");

        driver.get("https://chipotle.com");

        //driver.findElement(By.partialLinkText("order")).click();
        //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");

        //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");

        driver.get("https://order.chipotle.com");
        //driver.findElement(By.xpath("//*[text() = 'Talk To Us']")).click();
        driver.findElement(By.id("PartialAddress")).sendKeys("95064\n");
        //driver.findElement(By.id("findAddressSubmit")).click();

        //driver.findElement(By.partialLinkText("talk_to_us")).click();
        //driver.findElement(By.id())
        //<a href="https://chipotle.com/en-US/talk_to_us/talk_to_us.aspx" target="_blank">Talk To Us</a>
        //driver.findElement(By.xpath("//*[text() = 'foobar']"));
        //driver.findElement(By.id("ListView"))
        //driver.findElement(By.className("riderNow textButton round right")).click();

        //only goes to riverstreet chipotle
        driver.get("https://order.chipotle.com/Meal/Index/1716");

        //driver.findElement(By.id("dvSelectEntree")).click();//.sendKeys(Keys.PAGE_DOWN);
        //driver.findElement((By.partialLinkText("Burrito Bowl")));
        //driver.findElement(By.xpath("//div[@id='dvSelectEntree']/itemList/"));

        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,200)");

        //find type of the seven selections
        //WebElement menuItems = driver.findElement(By.id("dvSelectEntree"));

        List<WebElement> menuItems = driver.findElements(By.cssSelector("item shadow altShadow selected"));

        System.out.println("Number of menuItems " + menuItems.size());
        //find
        //driver.findElements(By.xpath("//div[@id='dvSelectEntree'][@id='cat2']")


//        WebElement WebElement =    driver.FindElement(By.XPath("//div[@class='facetContainerDiv']/div"));
//        // Create an IList and intialize it with all the elements of div under div with **class as facetContainerDiv**
//        IList<IWebElement> AllCheckBoxes = WebElement.FindElements(By.XPath("//label/input"));
//        // Get the count of check boxes
//        int RowCount = WebElement.FindElements(By.XPath("//label/input")).Count;
//        for (int i = 0; i < RowCount; i++)
//        {
//            // Check the check boxes based on index
//            AllCheckBoxes[i].Click();
//
//        }

        //driver.sendKeys(Keys.DOWN);

        //driver.findElement(By.linkText("BURRITO BOWL")).click();

    }


}
