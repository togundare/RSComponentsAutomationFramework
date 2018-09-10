package com.RSComponentsAutomation.framework.pageObjects;

import com.RSComponentsAutomation.framework.frameworkHelpers.pageObjectsUtility;
import org.openqa.selenium.By;
import java.io.IOException;

public class loginPage extends pageObjectsUtility {

    private By usernameField = By.name("username");
    private By passwordField = By.name("j_password");
    private By loginBtn = By.name("loginBtn");

    public void loginAsCustomer() throws IOException {
        String username = getDataFromLocale("account.username");
        String password = getDataFromLocale("account.password");
        waitForExpectedElement(usernameField).sendKeys(username);
        waitForExpectedElement(passwordField).sendKeys(password);
        clickLoginBtn();
    }

    public void clickLoginBtn(){
        waitForExpectedElement(loginBtn).click();
    }

}
