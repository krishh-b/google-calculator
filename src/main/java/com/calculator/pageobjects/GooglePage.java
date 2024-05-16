package com.calculator.pageobjects;

public class GooglePage {
    private static final String GOOGLE_SEARCH_TEXTBOX = "//textarea[@title='Search']";

    public static String getGoogleSearch() {
        return GOOGLE_SEARCH_TEXTBOX;
    }

}
