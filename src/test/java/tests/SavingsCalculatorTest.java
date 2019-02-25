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
        String actualTitle = getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Test
    public void itShouldCalculateTotalIncome (){
        selectFund("Hoggwart's Fund");
        inputInvestmentAmount("52000");
        inputInvestmentPeriod("4");

        String actualTotalIncome = getActualTotalIncome();
        Assert.assertFalse(actualTotalIncome.equals(""));
        Assert.assertTrue(actualTotalIncome.contains("kr"));
    }

    @Test
    public void itShouldCalculateNetIncome (){
        selectFund("Batman's Cave Development");
        inputInvestmentAmount("24000");
        inputInvestmentPeriod("13");

        String actualNetIncome = getActualNetIncome();
        Assert.assertFalse(actualNetIncome.equals(""));
        Assert.assertTrue(actualNetIncome.contains("kr"));
    }

    @After
    public void tearDown(){
        driver.close(); //closes browser
        driver.quit(); //quits session
    }

    private void selectFund(String fundName) {
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText(fundName);
    }

    private void inputInvestmentPeriod(String years) {
        driver.findElement(By.id("yearsInput")).sendKeys(years);
        driver.findElement(By.id("yearsInput")).sendKeys(Keys.TAB);
    }

    private void inputInvestmentAmount(String investment) {
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(investment);
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(Keys.TAB);
    }

    private String getActualTotalIncome(){
        return driver.findElement(By.cssSelector("div.result p")).getText();
    }

    private String getActualNetIncome(){
        return driver.findElement(By.xpath("//div[contains(@class,'result')]/div[2]/p")).getText();
    }

    private String getTitle (){
        return driver.findElement(By.cssSelector("h1")).getText();
    }
}
