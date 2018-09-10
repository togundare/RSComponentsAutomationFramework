package com.RSComponentsAutomation.framework.pageObjects;

import com.RSComponentsAutomation.framework.frameworkHelpers.pageObjectsUtility;
import org.openqa.selenium.By;

public class homePage extends pageObjectsUtility {

    private By RSComponentsLogo = By.cssSelector("#pageHeader > div.shHeader > a > i");
    private By loginLogout = By.cssSelector("#pageHeader > div.shHeader > div.loginContainer > div > a:nth-child(1)");
    private By cartIcon = By.cssSelector("#pageHeader > div > div.shBasket.js-basket > a > i");
    private By cartIconItemCount = By.cssSelector("#js-basketQty");
    private By searchBox = By.cssSelector("#searchTerm");
    private By searchBoxBtn = By.cssSelector("#btnSearch");
    private By acceptCookiesSettings = By.cssSelector("#js-cookie-accept");

    public boolean isHomepageLogoPresent(){
        return waitForExpectedElement(RSComponentsLogo).isDisplayed();
    }

    public void clickAcceptCookiesBtn(){
        if(driver.findElement(acceptCookiesSettings).isDisplayed()) {
            waitForExpectedElement(acceptCookiesSettings).click();
        }
    }

    public void clickLoginLogout(){
        waitForExpectedElement(loginLogout).click();
    }

    public void clickCartIcon(){
        waitForExpectedElement(cartIcon).click();
    }

    public boolean isCartEmpty(){
        return waitForExpectedElement(cartIconItemCount).getText().trim().equalsIgnoreCase("0");
    }
    public void makeASearch(String searchTerm){
        waitForExpectedElement(searchBox).sendKeys(searchTerm);
        waitForExpectedElement(searchBoxBtn).click();
    }
    public void startAsGuest(){
       String loginStatus = waitForExpectedElement(loginLogout).getAttribute("title").trim();
       if(loginStatus.equalsIgnoreCase("Log Out")){
           clickLoginLogout();
       }
    }
}
