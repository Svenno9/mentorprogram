package enumerators;

public enum RiskLevel {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High");

    public String getUiValue() {
        return uiValue;
    }

    private String uiValue;

    RiskLevel(String uiValue) {
        this.uiValue = uiValue;
    }
}
