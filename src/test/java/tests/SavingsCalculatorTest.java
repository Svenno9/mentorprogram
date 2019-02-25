package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SavingsCalculatorTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost/savingscalculator.php");
    }

    @Test
    public void itShouldDisplayTitle (){
        String expectedTitle = "Savings Calculator";
        String actualTitle = driver.findElement(By.cssSelector("h1")).getText();

        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Test
    public void itShouldCalculateTotalIncome (){
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Hoggwart's Fund");
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("52000");
        driver.findElement(By.id("yearsInput")).sendKeys("4");
        driver.findElement(By.id("yearsInput")).sendKeys(Keys.TAB);
        //driver.findElement(By.id("emailInput")).sendKeys("svenno1993@hotmail.com"); //is not needed in order to calculate

        String actualTotalIncome = driver.findElement(By.cssSelector("div.result p")).getText();
        Assert.assertFalse(actualTotalIncome.equals(""));
        Assert.assertTrue(actualTotalIncome.contains("kr"));


    }

    @After
    public void tearDown(){
        driver.close(); //closes browser
        driver.quit(); //quits session
    }

}
