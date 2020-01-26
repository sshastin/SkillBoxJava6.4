package Enums;

public enum BonusRates {
    TOP_MANAGER_BONUS_RATE(1.5),
    MANAGER_BONUS_RATE(0.05);

    private final Double BONUS_RATE;

    BonusRates(Double bonus) {
        this.BONUS_RATE = bonus;
    }

    public Double getBONUS_RATE() {
        return BONUS_RATE;
    }
}
