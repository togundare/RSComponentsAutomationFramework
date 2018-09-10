package com.RSComponentsAutomation.framework.pageObjects;

import com.RSComponentsAutomation.framework.frameworkHelpers.pageObjectsUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.List;

public class paymentPage extends pageObjectsUtility {

    private By paymentTypeRadioBtn = By.cssSelector("#paymentForm\\3a LoggedInUserSelectPaymentWidgetActionPAMLId > div > div.manageList > div > table > tbody > tr > td.radioTd > input");
    private By paymentTypes = By.cssSelector("#paymentForm\\3a LoggedInUserSelectPaymentWidgetActionPAMLId > div > div.manageList > div > table > tbody > tr > td> div > div > div.paymentText > span.paymentType.text");
    private By paymentCVVbox = By.cssSelector("#paymentForm\\3a LoggedInUserSelectPaymentWidgetActionPAMLId > div > div.manageList > div.manageListItem.manageListItemSelected > table > tbody > tr > td > div > div.helpInputDiv > input");
    private By orderPreviewBtn = By.id("checkoutSecurelyBtn");
    private By guestPaymentTypeRadioBtn = By.cssSelector("#paymentForm\\3a AddGuestEmbeddedPaymentWidgetAction_paymentFormDiv_Fields > table > tbody > tr > td > div.leftDiv > table > tbody > tr > td > input[type=\"radio\"]");
    private By guestCcardBox1 = By.cssSelector("#paymentForm\\3a AddGuestEmbeddedPaymentWidgetAction_cardNumber_decorate > span > input:nth-child(6)");
    private By guestCcardBox2 = By.cssSelector("#paymentForm\\3a AddGuestEmbeddedPaymentWidgetAction_cardNumber_decorate > span > input:nth-child(7)");
    private By guestCcardBox3 = By.cssSelector("#paymentForm\\3a AddGuestEmbeddedPaymentWidgetAction_cardNumber_decorate > span > input:nth-child(8)");
    private By guestCcardBox4 = By.cssSelector("#paymentForm\\3a AddGuestEmbeddedPaymentWidgetAction_cardNumber_decorate > span > input:nth-child(9)");
    private By guestPaymentTypes = By.cssSelector("#paymentForm\\3a AddGuestEmbeddedPaymentWidgetAction_paymentFormDiv_Fields > table > tbody > tr > td > div.leftDiv > table > tbody > tr > td > div > a");
    private By guestCreditCardName = By.cssSelector("#paymentForm\\3a AddGuestEmbeddedPaymentWidgetAction_cardHolder_decorate\\3a AddGuestEmbeddedPaymentWidgetAction_cardHolder");
    private By guestCreditCardExpDate = By.cssSelector("#paymentForm\\3a AddGuestEmbeddedPaymentWidgetAction_expiryDate_decorate\\3a AddGuestEmbeddedPaymentWidgetAction_expiryDate");
    private By guestCreditCardCVV = By.cssSelector("#paymentForm\\3a AddGuestEmbeddedPaymentWidgetAction_securityCode_decorate\\3a AddGuestEmbeddedPaymentWidgetAction_securityCode");
    private By guestCreditCardFullName = By.cssSelector("#paymentForm\\3a AddGuestEmbeddedPaymentWidgetAction_cardName_decorate\\3a AddGuestEmbeddedPaymentWidgetAction_cardName");


    public List<WebElement> allPaymentRadioBtns(){
        return visibilityOfAllElementsLocatedBy(paymentTypeRadioBtn);
    }

    public List<WebElement> allPaymentTypes(){
        return  visibilityOfAllElementsLocatedBy(paymentTypes);
    }

    public List<WebElement> guestPaymentRadioBtns(){ return visibilityOfAllElementsLocatedBy(guestPaymentTypeRadioBtn); }

    public List<WebElement> allGuestPaymentTypes(){ return visibilityOfAllElementsLocatedBy(guestPaymentTypes); }

    public void enterCVV(String paymentType) throws IOException {
        waitClearAndEnterText(paymentCVVbox).sendKeys(getDataFromLocale("allcards.cvv"));
    }

    public void selectAPaymentType(String paymentType){
        for(int i=0; i<allPaymentTypes().size(); i++){
            String paymentOption = allPaymentTypes().get(i).getText().trim();
            if(paymentOption.equalsIgnoreCase(paymentType)){
                allPaymentRadioBtns().get(i).click();
            }
        }
    }

    public void clickOrderPreviewBtn(){
        waitForExpectedElement(orderPreviewBtn).click();
    }

    public void selectGuestPaymentType(String paymentType){
        for(int i=0; i<allGuestPaymentTypes().size(); i++){
            String paymentOption = allGuestPaymentTypes().get(i).getAttribute("title").trim();
            if(paymentOption.equalsIgnoreCase(paymentType)){
                guestPaymentRadioBtns().get(i).click();
            }
        }
    }

    public void selectFromPaymentOptions(String paymentType, List<WebElement> options, List<WebElement> optionsBtn){
        for(int i=0; i< options.size(); i++){
            String paymentOption = options.get(i).getText().trim();
            if(paymentOption.equalsIgnoreCase(paymentType)){
                optionsBtn.get(i).click();
            }
        }
    }

    public void enterVisaCardDetials() throws IOException {
        waitForExpectedElement(guestCcardBox1).sendKeys(getDataFromLocale("visacard.number1"));
        waitForExpectedElement(guestCcardBox2).sendKeys(getDataFromLocale("visacard.number2"));
        waitForExpectedElement(guestCcardBox3).sendKeys(getDataFromLocale("visacard.number3"));
        waitForExpectedElement(guestCcardBox4).sendKeys(getDataFromLocale("visacard.number4"));
        enterOtherCardInformation();
    }

    public void enterMasterCardCardDetails() throws IOException {
        waitForExpectedElement(guestCcardBox1).sendKeys(getDataFromLocale("mastercard.number1"));
        waitForExpectedElement(guestCcardBox2).sendKeys(getDataFromLocale("mastercard.number2"));
        waitForExpectedElement(guestCcardBox3).sendKeys(getDataFromLocale("mastercard.number3"));
        waitForExpectedElement(guestCcardBox4).sendKeys(getDataFromLocale("mastercard.number4"));
        enterOtherCardInformation();
    }

    public void enterAmericanExpressCardDetails() throws IOException {
        waitForExpectedElement(guestCcardBox1).sendKeys(getDataFromLocale("americanexpress.number1"));
        waitForExpectedElement(guestCcardBox2).sendKeys(getDataFromLocale("americanexpress.number2"));
        waitForExpectedElement(guestCcardBox3).sendKeys(getDataFromLocale("americanexpress.number3"));
        enterOtherCardInformation();
    }

    public void enterOtherCardInformation() throws IOException {
        waitForExpectedElement(guestCreditCardName).sendKeys(getDataFromLocale("allcards.fullname"));
        waitForExpectedElement(guestCreditCardExpDate).sendKeys(getDataFromLocale("allcards.expdate"));
        waitForExpectedElement(guestCreditCardCVV).sendKeys(getDataFromLocale("allcards.cvv"));
        waitForExpectedElement(guestCreditCardFullName).sendKeys(getDataFromLocale("allcards.fullname"));
    }

}
