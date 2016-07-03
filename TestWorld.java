/*/**
 * Created by Justin on 6/27/16.
 */

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.*;


public class TestWorld {

    String loginEmail = "jus.lee18@gmail.com";
    String password = "Aa1234!@#$";
    int atAlameda = 1;
    int atSantaCruz = 0;

    /** http://seleniumhq.org **/
    @Test
    public void orderChipotle() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/res/webdriver/chromedriver");

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='findAddressSubmit']/input"))).sendKeys("95064");

        driver.get("https://chipotle.com");


        //driver.findElement(By.partialLinkText("order")).click();
        //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");

        //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");

        driver.get("https://order.chipotle.com");

        WebDriverWait wait = new WebDriverWait(driver, 10);


        //sign on
        driver.findElement(By.id("signIn")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logonDialog")));

        Actions login = new Actions(driver);
        login.sendKeys(loginEmail);
        login.sendKeys("\t");
        login.sendKeys(password);
        login.sendKeys("\n");
        Action typeIt = login.build();
        typeIt.perform();

        //Find nearest location
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("PartialAddress")));
//        driver.findElement(By.id("PartialAddress")).sendKeys("95064\n");


        driver.get("https://order.chipotle.com/Meal/Index/1716");
        if(atSantaCruz == 1){
            driver.get("https://order.chipotle.com/Meal/Index/1716");
        }else if(atAlameda == 1){
            driver.get("https://order.chipotle.com/Meal/Index/1206");
        }else{
            System.exit(0);
        }

        js.executeScript("window.scrollBy(0,500)");
//
//        System.out.println("before loop.");

        //WebElement bowl =
        driver.findElement(By.xpath("//*[@id = 'dvSelectEntree']/div[3]/div[2]")).click();

        //entreeMods/modsContent/modsContentBody/column meat seperate2
        WebElement steak = driver.findElement(By.xpath("//*[@id = 'entreeMods']/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]"));//last div is menu item
        System.out.println(steak.getText());
        steak.click();

        //entreeMods/modsContent/modsContentBody/column sides seperate3
        WebElement whiteRice = driver.findElement(By.xpath("//*[@id = 'entreeMods']/div[2]/div[2]/div[3]/div[1]/div[2]/div[2]"));//last div is menu item
        System.out.println(whiteRice.getText());
        whiteRice.click();

        //3 pintoBeans
        WebElement pintoBeans = driver.findElement(By.xpath("//*[@id = 'entreeMods']/div[2]/div[2]/div[3]/div[1]/div[4]/div[3]"));//last div is menu item
        System.out.println(pintoBeans.getText());
        pintoBeans.click();

        //2 mildsalsa
        WebElement mildSalsa = driver.findElement(By.xpath("//*[@id = 'entreeMods']/div[2]/div[2]/div[4]/div[1]/div[2]/div[2]"));//last div is menu item
        System.out.println(mildSalsa.getText());
        mildSalsa.click();

        //6 sourcream
        WebElement sourCream = driver.findElement(By.xpath("//*[@id = 'entreeMods']/div[2]/div[2]/div[4]/div[1]/div[2]/div[6]"));//last div is menu item
        System.out.println(sourCream.getText());
        sourCream.click();

        //7 scheese
        WebElement cheese = driver.findElement(By.xpath("//*[@id = 'entreeMods']/div[2]/div[2]/div[4]/div[1]/div[2]/div[7]"));//last div is menu item
        System.out.println(cheese.getText());
        cheese.click();

        //8 guac
        WebElement guac = driver.findElement(By.xpath("//*[@id = 'entreeMods']/div[2]/div[2]/div[4]/div[1]/div[2]/div[8]"));//last div is menu item
        System.out.println(guac.getText());
        guac.click();

        //9 lettuce
        WebElement lettuce = driver.findElement(By.xpath("//*[@id = 'entreeMods']/div[2]/div[2]/div[4]/div[1]/div[2]/div[9]"));//last div is menu item
        System.out.println(lettuce.getText());
        lettuce.click();

        //scroll to the bottom of the page
        js.executeScript("window.scrollBy(0,900)");

        //click ADD TO BAG
        WebElement addToBag = driver.findElement(By.xpath("//*[@id = 'addBag']/div[2]"));
        addToBag.click();


        //WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("mealNameDialog")));

        Actions action = new Actions(driver);
        action.sendKeys("Justins Bot\n");
        Action doIt = action.build();
        doIt.perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
        WebElement checkout = driver.findElement(By.xpath("//*[id@ = 'checkout']/a[1]"));
        checkout.click();



    }
}


