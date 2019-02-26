package models;

import enumerators.RiskLevel;
import utils.FormatterHelper;

public class SavingResult {
    private String totalIncome;
    private String interestIncome;
    private RiskLevel risk;

    public String getTotalIncome() {
        return totalIncome;
    }

    public String getInterestIncome() {
        return interestIncome;
    }

    public RiskLevel getRiskLevel() {
        return risk;
    }

    public void setTotalIncome(String totalIncome) {
        this.totalIncome = totalIncome;
    }

    public void setInterestIncome(String interestIncome) {
        this.interestIncome = interestIncome;
    }

    public void setRisk(RiskLevel risk) {
        this.risk = risk;
    }

    public Double getTotalIncomeAsDouble(String amount) {
        return FormatterHelper.amountToDouble(amount);
    }
}
