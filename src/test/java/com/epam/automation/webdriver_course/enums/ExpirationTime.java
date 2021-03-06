package com.epam.automation.webdriver_course.enums;

public enum ExpirationTime {
    NEVER("Never"),
    BURN_AFTER_READ("Burn after read"),
    MINUTES_10("10 Minutes"),
    HOUR_1("1 Hour"),
    DAY_1("1 Day"),
    WEEK_1("1 Week"),
    WEEK_2("2 Week"),
    MONTH_1("1 Month"),
    MONTH_6("6 Month");

    private final String expirationTime;

    ExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getExpirationTime() {
        return expirationTime;
    }
}
