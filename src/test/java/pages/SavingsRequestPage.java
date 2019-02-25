package pages;

import enumerators.RiskLevel;
import models.SavingRequest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SavingsRequestPage {
    @FindBy(id = "oneTimeInvestmentInput")
    private WebElement oneTimeInvestmentInput;

    @FindBy(id = "yearsInput")
    private WebElement yearsInput;

    //@FindBy(css = "div.result p")
    //private WebElement actualTotalIncome;
    //@FindBy(xpath = "//div[contains(@class,'result')]/div[2]/p")
    //private  WebElement actualNetIncome;
    // use wrapper instead
    @FindBy(css = "div.result")
    private WebElement resultWrapper;

    @FindBy(css = "h1")
    private WebElement title;

    @FindBy(id = "fundSelect")
    private WebElement fund;

    @FindBy(id = "emailInput")
    private  WebElement emailInput;

    @FindBy(css = "button.btn")
    private WebElement applySavingForButton;

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
        return resultWrapper.findElement(By.cssSelector("p")).getText();
    }

    public String getActualNetIncome(){
        return resultWrapper.findElement(By.xpath("./div[2]/p")).getText();
    }

    public RiskLevel getRiskLevel() {
        String displayedRisk = resultWrapper.findElement(By.xpath("./div[3]/p")).getText();
        RiskLevel riskLevel = RiskLevel.valueOf(displayedRisk.toUpperCase());
        return riskLevel;
    }

    public void inputEmail(String email) {
        emailInput.sendKeys(email);
    }

    public WebElement getApplySavingForButton() {
        return applySavingForButton;
    }

    public List<WebElement> getListOfAllRequest() {
        return driver.findElements(By.cssSelector("ul.saving-list li"));
    }

    public void enterNewSavingRequestData(SavingRequest request){
        selectFund(request.getFund());
        inputInvestmentAmount(request.getOneTimeInvestment());
        inputInvestmentPeriod(String.valueOf(request.getYears()));
        inputEmail(request.getEmail());
    }

    public void checkMostRecentSavingRequest(SavingRequest request) {
        //getting the most recent saving request element
        WebElement mostRecentSavingRequest = getListOfAllRequest().get(0);

        // getting the actual text from the element
        //check div.amount to check an area, this will reduce the chance of test breaking
        String requestText = mostRecentSavingRequest.findElement(By.cssSelector("div.amounts")).getText();
        String requestRisk = mostRecentSavingRequest.findElement(By.cssSelector("p.risk")).getText();

        //comparing the actual tesxt with SavingRequest data
        Assert.assertTrue(requestText.contains(request.getSavingResult().getTotalIncome()));
        Assert.assertTrue(requestRisk.contains(request.getSavingResult().getRiskLevel().getUiValue()));
    }
}
