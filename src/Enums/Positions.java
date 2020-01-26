package Enums;

public enum Positions {
    MANAGER("Manager"),
    TOP_MANAGER("Top manager"),
    OPERATOR("Operator");

    private final String POSITION_NAME;

    Positions(String positionName) {
        this.POSITION_NAME = positionName;
    }

    public String getPOSITION_NAME() {
        return POSITION_NAME;
    }
}
