package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SavingsRequestPage {
    private WebDriver driver;

    public SavingsRequestPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle (){
        return driver.findElement(By.cssSelector("h1")).getText();
    }

    public void selectFund(String fundName) {
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText(fundName);
    }

    public void inputInvestmentPeriod(String years) {
        driver.findElement(By.id("yearsInput")).sendKeys(years);
        driver.findElement(By.id("yearsInput")).sendKeys(Keys.TAB);
    }

    public void inputInvestmentAmount(String investment) {
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(investment);
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(Keys.TAB);
    }

    public String getActualTotalIncome(){
        return driver.findElement(By.cssSelector("div.result p")).getText();
    }

    public String getActualNetIncome(){
        return driver.findElement(By.xpath("//div[contains(@class,'result')]/div[2]/p")).getText();
    }
}
