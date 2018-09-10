package com.RSComponentsAutomation.framework.pageObjects;

import com.RSComponentsAutomation.framework.frameworkHelpers.pageObjectsUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class deliveryAddressPage extends pageObjectsUtility {

    private By savedAddress = By.cssSelector("#listAddressListId > div.manageListItem.manageListItemSelected > table > tbody > tr > td.listAddressItemdataTd > div");
    private By addAddressBtn = By.cssSelector("#deliveryCollectionForm\\3a j_idt1360");
    private By companyName = By.id("deliveryCollectionForm:AddDeliveryAddressWidgetAction_companyNameOne_decorate:AddDeliveryAddressWidgetAction_companyNameOne");
    private By proceedToPayment = By.cssSelector("#checkoutSecurelyBtn");
    private By guestTitle = By.cssSelector("#deliveryCollectionForm\\3a CustomerContactDetailsWidgetAction_title_decorate > span > select");
    private By guestFirstName = By.cssSelector("#deliveryCollectionForm\\3a CustomerContactDetailsWidgetAction_firstName_decorate\\3a CustomerContactDetailsWidgetAction_firstName");
    private By guestSurname = By.cssSelector("#deliveryCollectionForm\\3a CustomerContactDetailsWidgetAction_surName_decorate\\3a CustomerContactDetailsWidgetAction_surName");
    private By guestPhone = By.cssSelector("#deliveryCollectionForm\\3a CustomerContactDetailsWidgetAction_contactNumber_decorate\\3a CustomerContactDetailsWidgetAction_contactNumber");
    private By guestFullName = By.cssSelector("#deliveryCollectionForm\\3a GuestDeliveryAddressWidgetAction_companyNameOne_decorate\\3a GuestDeliveryAddressWidgetAction_companyNameOne");
    private By guestAddressLine1 = By.cssSelector("#deliveryCollectionForm\\3a GuestDeliveryAddressWidgetAction_addressLineOne_decorate\\3a GuestDeliveryAddressWidgetAction_addressLineOne");
    private By guestAddressLine2 = By.cssSelector("#deliveryCollectionForm\\3a GuestDeliveryAddressWidgetAction_addressLineTwo_decorate\\3a GuestDeliveryAddressWidgetAction_addressLineTwo");
    private By guestTown = By.cssSelector("#deliveryCollectionForm\\3a GuestDeliveryAddressWidgetAction_addressLineThree_decorate\\3a GuestDeliveryAddressWidgetAction_addressLineThree");
    private By guestCounty = By.cssSelector("#deliveryCollectionForm\\3a GuestDeliveryAddressWidgetAction_selectedRegion_decorate\\3a selectedRegion");
    private By guestPostcode = By.cssSelector("#deliveryCollectionForm\\3a GuestDeliveryAddressWidgetAction_postCode_decorate\\3a GuestDeliveryAddressWidgetAction_postCode");

    public WebElement savedAddressElement(){
        return waitForExpectedElement(savedAddress);
    }

    public void clickAddAddressBtn(){
        clickElementUsingJavascriptExecutor(waitForExpectedElement(addAddressBtn));
    }

    public void enterAddressInformation(){
        waitForExpectedElement(companyName).sendKeys("getin2testing");
    }

    public void clickProceedToPayment(){
        waitForExpectedElement(proceedToPayment).click();
    }

    public void enterDeliveryAddressAsGuest() throws IOException {
        selectByText(waitForExpectedElement(guestTitle), getDataFromLocale("title"));
        waitForExpectedElement(guestFirstName).sendKeys(getDataFromLocale("first.name"));
        waitForExpectedElement(guestSurname).sendKeys(getDataFromLocale("last.name"));
        waitForExpectedElement(guestPhone).sendKeys(getDataFromLocale("contact.phone"));
        waitForExpectedElement(guestFullName).sendKeys(getDataFromLocale("guest.fullname"));
        waitForExpectedElement(guestAddressLine1).sendKeys(getDataFromLocale("address.line1"));
        waitForExpectedElement(guestAddressLine2).sendKeys(getDataFromLocale("address.line2"));
        waitForExpectedElement(guestTown).sendKeys(getDataFromLocale("address.town"));
        selectByText(waitForExpectedElement(guestCounty), getDataFromLocale("address.county"));
        waitForExpectedElement(guestPostcode).sendKeys(getDataFromLocale("address.postcode"));
    }
}
