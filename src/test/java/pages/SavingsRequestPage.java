package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SavingsRequestPage {
    @FindBy(id = "oneTimeInvestmentInput")
    private WebElement oneTimeInvestmentInput;

    @FindBy(id = "yearsInput")
    private WebElement yearsInput;

    @FindBy(css = "div.result p")
    private WebElement actualTotalIncome;

    @FindBy(xpath = "//div[contains(@class,'result')]/div[2]/p")
    private  WebElement actualNetIncome;

    @FindBy(css = "h1")
    private WebElement title;

    @FindBy(id = "fundSelect")
    private WebElement fund;

    private WebDriver driver;

    public SavingsRequestPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle (){
        return title.getText();
    }

    public void selectFund(String fundName) {
        new Select(fund).selectByVisibleText(fundName);
    }

    public void inputInvestmentPeriod(String years) {
        yearsInput.sendKeys(years);
        yearsInput.sendKeys(Keys.TAB);
    }

    public void inputInvestmentAmount(String investment) {
        oneTimeInvestmentInput.sendKeys(investment);
        oneTimeInvestmentInput.sendKeys(Keys.TAB);
    }

    public String getActualTotalIncome(){
        return actualTotalIncome.getText();
    }

    public String getActualNetIncome(){
        return actualNetIncome.getText();
    }
}
