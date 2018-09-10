package com.RSComponentsAutomation.framework.pageObjects;

import com.RSComponentsAutomation.framework.frameworkHelpers.pageObjectsUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class orderReviewPage extends pageObjectsUtility {

    private By orderReviewTitle = By.cssSelector("#orderReviewForm > div.orderReviewLayoutContainer > div.deliveryHeaderDiv > span");
    private By placeOrderBtn = By.cssSelector("#checkoutSecurelyBtn");
    private By grandTotal = By.cssSelector("#orderReviewForm\\3a CheckoutNotificationSettingsWidgetAction_faoContactDetailsDisplayDiv > table > tbody > tr > td > div > div > div > span");


    public WebElement getOrderReviewTitle(){
        return waitForExpectedElement(orderReviewTitle);
    }

    public List<WebElement> getPlaceOrderBtns(){
        return visibilityOfAllElementsLocatedBy(placeOrderBtn);
    }

    public String getGrandTotal(){
        return waitForExpectedElement(grandTotal).getText().trim();
    }
}
