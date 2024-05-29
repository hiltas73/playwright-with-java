package com.cydeo.tests.day_01.pac02_locators_getText_getAttribute;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P02_ClickLinkWithText {

    @Test
    void test() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                //if you want to see browser pass this line
                new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/");

        page.waitForTimeout(1000);
        page.setViewportSize(1920, 1080);
        // click the link with this text
        page.click("text=Autocomplete");

        page.waitForTimeout(2000);

        System.out.println("page.title() = " + page.title());

        Assertions.assertEquals("Autocomplete", page.title());

        page.close();
        browser.close();
        playwright.close();

    }

}
