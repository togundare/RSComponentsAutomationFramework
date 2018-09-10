package com.RSComponentsAutomation.framework.stepsDefinitions;

import com.RSComponentsAutomation.framework.models.orderModel;
import com.RSComponentsAutomation.framework.pageObjects.*;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

public class checkoutSteps {

    private homePage HomePage;
    private loginPage LoginPage;
    private basketPage BasketPage;
    private searchPage SearchPage;
    private orderModel OrderModel;
    private deliveryAddressPage DeliveryAddressPage;
    private paymentPage PaymentPage;
    private orderReviewPage OrderReviewPage;

    public checkoutSteps(homePage homePage,loginPage loginPage,basketPage basketPage,searchPage searchPage,orderModel orderModel,
    deliveryAddressPage deliveryAddressPage,paymentPage paymentPage,orderReviewPage orderReviewPage){
        this.HomePage = homePage;
        this.LoginPage = loginPage;
        this.BasketPage = basketPage;
        this.SearchPage = searchPage;
        this.OrderModel = orderModel;
        this.DeliveryAddressPage = deliveryAddressPage;
        this.PaymentPage = paymentPage;
        this.OrderReviewPage = orderReviewPage;
    }

    @Given("^RS Components homepage is displayed$")
    public void RSComponentsHomepageIsDisplayed() throws Throwable {
        HomePage.startHomepage();
        assertTrue(HomePage.isHomepageLogoPresent());
    }

    @And("^I am logged in as a customer$")
    public void iAmLoggedIn() throws IOException {
        HomePage.clickLoginLogout();
        LoginPage.loginAsCustomer();
    }

    @And("^I am a guest customer$")
    public void iAmAGuestCustomer(){
        HomePage.startAsGuest();
    }

    @And("^my basket is clear$")
    public void myBasketIsClear() throws InterruptedException {
        if(!HomePage.isCartEmpty()){
            HomePage.clickCartIcon();
            //HomePage.waitForSurveyPopupAndClose();
            BasketPage.clickClearBasketBtn();
            BasketPage.clickConfirmClearBasketBox();
            BasketPage.timeUnitWait(3);
            BasketPage.clickReturnToHome();
        }
    }

    @When("^I search for '(.*)'$")
    public void iSearchForItem(String searchTerm){
        HomePage.makeASearch(searchTerm);
    }

    @And("^I change the quantity of first product to '(.*)'$")
    public void iChangeTheQuantity(String Qty){
        SearchPage.changeFirstItemQuantity(Qty);
        OrderModel.setItemQty(Qty);
    }

    @And("^I add (?:first product|the product) to basket from results list$")
    public void iAddFirstProductToBagFromResultsList(){
        SearchPage.addFirstItemToCartFromSearchResults();
        String itemPrice = SearchPage.getFirstItemPriceFromSearchResults();
        String itemStockNo = SearchPage.getFirstItemStockNoFromSearchResults();
        OrderModel.setItemPrice(itemPrice);
        OrderModel.setItemStockNo(itemStockNo);
    }
    @And("^I proceed to basket summary$")
    public void iProceedToBasketSummary(){
        HomePage.clickCartIcon();
    }

    @And("^I verify basket information is correct$")
    public void iVerifyBasketInformationIsCorrect(){
        assertEquals(OrderModel.getItemPrice(), BasketPage.getItemPriceInCart("1"));
        assertEquals(OrderModel.getItemStockNo(), BasketPage.getItemStockNoInCart("1"));
        assertEquals(OrderModel.getItemQty(), BasketPage.getItemQtyInCart("1"));
        assertTrue(BasketPage.checkAllItemTotal());
        assertTrue(BasketPage.checkAllItemTotal());
        assertTrue(BasketPage.checkGoodsTotal());
        assertTrue(BasketPage.checkGrandTotalIsCorrect());
        OrderModel.setGrandTotal(BasketPage.getGrandTotal());
    }

    @And("^I proceed to checkout$")
    public void iProceedToCheckout() { BasketPage.clickCheckoutBtn(); }

    @And("^I proceed to checkout as guest$")
    public void iProceedToCheckoutAsGuest() throws IOException, InterruptedException {
        BasketPage.clickCheckoutBtn();
        BasketPage.enterGuestCheckoutEmail(BasketPage.getDataFromLocale("email.guest"));
        BasketPage.clickGuestCheckoutBtn();
        BasketPage.timeUnitWait(3);
    }

    @And("^I verify saved address is present$")
    public void iVerifySavedAddressIsPresent(){
        assertTrue(DeliveryAddressPage.savedAddressElement().isDisplayed());
    }

    @And("^I add a new delivery address$")
    public void iAddANewDeliveryAddress(){
        DeliveryAddressPage.clickAddAddressBtn();
        DeliveryAddressPage.enterAddressInformation();
    }
    @And("^I proceed to payment$")
    public void iProceedToPayment(){
        DeliveryAddressPage.clickProceedToPayment();
    }

    @And("^I select '(.*)' from saved cards$")
    public void iSelectFromSavedCards(String paymentType) throws IOException {
        PaymentPage.selectAPaymentType(paymentType);
        PaymentPage.enterCVV();
    }

    @And("^I proceed to order review$")
    public void iProceedToOrderReview(){
        PaymentPage.clickOrderPreviewBtn();
    }

    @Then("^I verify order review page is displayed$")
    public void iVerifyOrderReviewPageIsDisplayed(){
       assertTrue(OrderReviewPage.getOrderReviewTitle().isDisplayed());
       assertTrue(OrderReviewPage.getPlaceOrderBtns().get(0).isDisplayed());
       assertTrue(OrderReviewPage.getPlaceOrderBtns().get(1).isDisplayed());
    }

    @And("^I verify order information is correct$")
    public void iVerifyOrderInformation(){
        assertEquals(OrderModel.getGrandTotal(), OrderReviewPage.getGrandTotal());
    }

    @And("^I add delivery information$")
    public void iAddDeliveryInformation() throws IOException {
        DeliveryAddressPage.enterDeliveryAddressAsGuest();
    }

    @And("^I add '(.*)' payment details$")
    public void iAddPaymentDetails(String paymentType) throws IOException {
        PaymentPage.selectGuestPaymentType(paymentType);
        if(paymentType.equals("Visa")){
            PaymentPage.enterVisaCardDetials();
        } else if(paymentType.equals("MasterCard")){
            PaymentPage.enterMasterCardCardDetails();
        } else if(paymentType.equals("American Express")){
            PaymentPage.enterAmericanExpressCardDetails();
        }
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) HomePage.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
    }

}