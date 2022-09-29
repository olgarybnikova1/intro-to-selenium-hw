package com.example.selenium.steps;

import com.example.selenium.pages.LoginPage;
import com.example.selenium.pages.MainPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class UserSteps {
    private WebDriver driver;
    private MainPage mainPage;

    public UserSteps(WebDriver driver) {
        this.driver = driver;
    }

    public com.example.selenium.steps.UserSteps login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        mainPage = loginPage.clickLogin();
        assertTrue(mainPage.getTitle().contains("Secure Area"), "Login failed");
        return this;
    }

    public UserSteps logout() {
        mainPage.clickLogout();
        return this;
    }
}
