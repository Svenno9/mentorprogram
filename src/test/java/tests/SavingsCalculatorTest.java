package tests;

import context.TestBase;
import models.SavingRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.SavingsRequestPage;
import testData.SavingRequestsExamples;

public class SavingsCalculatorTest extends TestBase {
    private SavingsRequestPage savingsRequestPage;
    private SavingRequestsExamples savingRequestsExamples;

    @Before
    public void openPage() {
        savingsRequestPage = new SavingsRequestPage(driver);
        savingRequestsExamples = new SavingRequestsExamples();
        savingsRequestPage.openPage();
    }

    @Test
    public void itShouldDisplayTitle() {
        String expectedTitle = "Savings Calculator";
        String actualTitle = savingsRequestPage.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void itShouldCalculateTotalIncome() {
        savingsRequestPage.selectFund("Hoggwart's Fund");
        savingsRequestPage.inputInvestmentAmount("52000");
        savingsRequestPage.inputInvestmentPeriod("4");

        String actualTotalIncome = savingsRequestPage.getActualTotalIncome();
        Assert.assertFalse(actualTotalIncome.equals(""));
        Assert.assertTrue(
                "Total income should contain currency kr",
                actualTotalIncome.contains("kr"));
    }

    @Test
    public void itShouldCalculateNetIncome() {
        savingsRequestPage.selectFund("Batman's Cave Development");
        savingsRequestPage.inputInvestmentAmount("24000");
        savingsRequestPage.inputInvestmentPeriod("13");

        String actualNetIncome = savingsRequestPage.getActualNetIncome();
        Assert.assertFalse(actualNetIncome.equals(""));
        Assert.assertTrue(actualNetIncome.contains("kr"));
    }

    @Test
    public void itShouldEnableAddSavingButton() {
        SavingRequest request = savingRequestsExamples.getRequest1();
        savingsRequestPage.enterNewSavingRequestData(request);

        Assert.assertTrue(savingsRequestPage.getApplySavingForButton().isEnabled());
    }

    @Test
    public void itShouldAddNewRequestToTheRecentRequestList() {
        //arrange
        SavingRequest request = savingRequestsExamples.getRequest1();

        int initialNumberOfRequests = savingsRequestPage.getListOfAllRequest().size();
        savingsRequestPage.enterNewSavingRequestData(request);
        //act
        savingsRequestPage.getApplySavingForButton().click();
        //assert
        int currentNumberOfRequests = savingsRequestPage.getListOfAllRequest().size();
        Assert.assertEquals(initialNumberOfRequests + 1, currentNumberOfRequests);
    }

    @Test
    public void itShouldStoreCorrectResultDataInNewSavingsRequest() {
        SavingRequest request = savingRequestsExamples.getRequest1();
        savingsRequestPage.enterNewSavingRequestData(request);

        request.getSavingResult().setTotalIncome(savingsRequestPage.getActualTotalIncome());
        request.getSavingResult().setInterestIncome(savingsRequestPage.getActualNetIncome());
        request.getSavingResult().setRisk(savingsRequestPage.getRiskLevel());

        savingsRequestPage.getApplySavingForButton().click();
        savingsRequestPage.checkMostRecentSavingRequest(request);
    }

    //@Test
    //findByShouldBeAbleToHandleList(){

    //}
}
