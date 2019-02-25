package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SavingsRequestPage;

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
        SavingsRequestPage savingsRequestPage = new SavingsRequestPage(driver);
        String expectedTitle = "Savings Calculator";
        String actualTitle = savingsRequestPage.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Test
    public void itShouldCalculateTotalIncome (){
        SavingsRequestPage savingsRequestPage = new SavingsRequestPage(driver);
        savingsRequestPage.selectFund("Hoggwart's Fund");
        savingsRequestPage.inputInvestmentAmount("52000");
        savingsRequestPage.inputInvestmentPeriod("4");

        String actualTotalIncome = savingsRequestPage.getActualTotalIncome();
        Assert.assertFalse(actualTotalIncome.equals(""));
        Assert.assertTrue(actualTotalIncome.contains("kr"));
    }

    @Test
    public void itShouldCalculateNetIncome (){
        SavingsRequestPage savingsRequestPage = new SavingsRequestPage(driver);
        savingsRequestPage.selectFund("Batman's Cave Development");
        savingsRequestPage.inputInvestmentAmount("24000");
        savingsRequestPage.inputInvestmentPeriod("13");

        String actualNetIncome = savingsRequestPage.getActualNetIncome();
        Assert.assertFalse(actualNetIncome.equals(""));
        Assert.assertTrue(actualNetIncome.contains("kr"));
    }

    @After
    public void tearDown(){
        driver.close(); //closes browser
        driver.quit(); //quits session
    }
}
