package models;

public class SavingRequest {
    private String fund;
    private String oneTimeInvestment;
    private int years;
    private String email;
    private SavingResult savingResult;

    public SavingRequest(String fund, String oneTimeInvestment, int years, String email) {
        this.fund = fund;
        this.oneTimeInvestment = oneTimeInvestment;
        this.years = years;
        this.email = email;
        this.savingResult = new SavingResult();
    }

    public SavingResult getSavingResult() {
        return savingResult;
    }

    public String getFund() {
        return fund;
    }

    public String getOneTimeInvestment() {
        return oneTimeInvestment;
    }

    public int getYears() {
        return years;
    }

    public String getEmail() {
        return email;
    }
}
