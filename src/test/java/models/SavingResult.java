package models;

import enumerators.RiskLevel;

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
}
