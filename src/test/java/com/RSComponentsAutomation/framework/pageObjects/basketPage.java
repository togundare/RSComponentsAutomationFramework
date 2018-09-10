package com.RSComponentsAutomation.framework.pageObjects;

import com.RSComponentsAutomation.framework.frameworkHelpers.pageObjectsUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.text.DecimalFormat;
import java.util.List;

public class basketPage extends pageObjectsUtility {

    private By clearBasketBtn = By.cssSelector("#clearBasketButton > span");
    private By confirmClearBasketBtn2 = By.xpath("//*[@id=\"confirmDeleteContinue\"]//span");
    private By listOfItemsPrices = By.cssSelector("#shoppingBasketForm\\3a WebBasketLineWidgetActionVALIDATION_ERROR_EVENT > table > tbody > tr > td.unitTd > div:nth-child(1)");
    private By listOfItemsStockNo = By.cssSelector("#shoppingBasketForm\\3a WebBasketLineWidgetActionVALIDATION_ERROR_EVENT > table > tbody > tr > td.descriptionTd > div > span.textTitle");
    private By listOfItemsQty = By.cssSelector("#shoppingBasketForm\\3a WebBasketLineWidgetActionVALIDATION_ERROR_EVENT > table > tbody > tr > td.quantityTd > input");
    private By checkoutBtn = By.id("checkoutSecurelyAndPuchBtn");
    private By returnToHome = By.cssSelector("#pageHeader > div.shHeader > a > i");
    private By grandTotal = By.cssSelector("#shoppingBasketForm\\3a OrderTotalDetailWidgetActionCARTTotalsDIVId > table > tbody > tr > td.orderValueCell.grandTotalCell");
    private By itemTotalPrice = By.cssSelector("#shoppingBasketForm\\3a WebBasketLineWidgetActionVALIDATION_ERROR_EVENT > table > tbody > tr > td.costTd.last > div");
    private By goodsTotal = By.cssSelector("#shoppingBasketForm\\3a OrderTotalDetailWidgetActionCARTTotalsDIVId > table > tbody > tr:nth-child(1) > td.orderValueCell");
    private By orderTax = By.cssSelector("#shoppingBasketForm\\3a OrderTotalDetailWidgetActionCARTTotalsDIVId > table > tbody > tr:nth-child(3) > td.orderValueCell.tax");
    private By shippingPrice = By.cssSelector("#shoppingBasketForm\\3a OrderTotalDetailWidgetActionCARTTotalsDIVId > table > tbody > tr:nth-child(2) > td.orderValueCell.freeDelivery");
    private By guestEmail = By.cssSelector("#guestCheckoutForm\\3a GuestWidgetAction_emailAddress_decorate\\3a GuestWidgetAction_emailAddress");
    private By guestCheckoutBtn = By.cssSelector("#guestCheckoutForm\\3a guestCheckout");


    public void clickClearBasketBtn() {
        waitForExpectedElement(clearBasketBtn).click();
    }

    public void clickConfirmClearBasketBox() {
        clickElementUsingJavascriptExecutor(waitForExpectedElement(confirmClearBasketBtn2));
    }

    public String getItemPriceInCart(String itemsNoInCart) {
        return visibilityOfAllElementsLocatedBy(listOfItemsPrices).get(Integer.parseInt(itemsNoInCart) - 1).getText().trim();
        //keeping this method to use passed string itemNoInCart so can be re-used for getting price of other items in cart
    }

    public String getItemStockNoInCart(String itemNo) {
        return visibilityOfAllElementsLocatedBy(listOfItemsStockNo).get(Integer.parseInt(itemNo) - 1).getText().trim();
    }

    public String getItemQtyInCart(String itemNo) {
        return visibilityOfAllElementsLocatedBy(listOfItemsQty).get(Integer.parseInt(itemNo) - 1).getAttribute("value").trim();
    }

    public List<WebElement> getItemTotalPrice() {
        return visibilityOfAllElementsLocatedBy(itemTotalPrice);
    }

    public List<WebElement> getItemEachPrice() {
        return visibilityOfAllElementsLocatedBy(listOfItemsPrices);
    }

    public List<WebElement> getItemQuantity() {
        return visibilityOfAllElementsLocatedBy(listOfItemsQty);
    }

    public void clickCheckoutBtn() {
        waitForExpectedElement(checkoutBtn).click();
    }

    public void clickReturnToHome() {
        waitForExpectedElement(returnToHome).click();
    }

    public String getGrandTotal() {
        return waitForExpectedElement(grandTotal).getText().trim();
    }

    public boolean checkAllItemTotal() {
        boolean itemTotalIsCorrect = false;
        for (int i = 0; i < getItemTotalPrice().size(); i++) {
            double itemEachPrice = TrimPoundAndConvertToDouble(getItemEachPrice().get(i).getText().trim());
            double itemQuantity = TrimPoundAndConvertToDouble(getItemQuantity().get(i).getAttribute("value").trim());
            double itemTotalPrice = TrimPoundAndConvertToDouble(getItemTotalPrice().get(i).getText().trim());
            double expectedItemTotal = itemEachPrice * itemQuantity;
            if (expectedItemTotal != itemTotalPrice) {
                itemTotalIsCorrect = false;
                break;
            } else if (expectedItemTotal == itemTotalPrice) {
                itemTotalIsCorrect = true;
            }
        }
        return itemTotalIsCorrect;
    }

    public boolean checkGoodsTotal() {
        boolean value = false;
        double total = 0;
        for (int i = 0; i < getItemTotalPrice().size(); i++) {
            String itemTotal = getItemTotalPrice().get(i).getText().trim();
            double ConvertedItemTotal = TrimPoundAndConvertToDouble(itemTotal);
            if (total >= 0) {
                total = total + ConvertedItemTotal;
            }
        }
        double expectedTotal = TrimPoundAndConvertToDouble(waitForExpectedElement(goodsTotal).getText().trim());
        if (total == expectedTotal) {
            value = true;
        }
        return value;
    }

    public double getShippingPrice(){
        double value;
        String shippingPriceValue = waitForExpectedElement(shippingPrice).getText().trim();
        if(shippingPriceValue.equalsIgnoreCase("Free")){
            value = 0.00;
        }else{
            value = TrimPoundAndConvertToDouble(shippingPriceValue);
        }
        return value;
    }

    public boolean checkGrandTotalIsCorrect(){
        boolean value = false;
        double orderGoodsTotal = TrimPoundAndConvertToDouble(waitForExpectedElement(goodsTotal).getText().trim());
        double shippingPrice = getShippingPrice();
        double VAT = TrimPoundAndConvertToDouble(waitForExpectedElement(orderTax).getText().trim());
        double orderGrandTotal = TrimPoundAndConvertToDouble(getGrandTotal());
        Double expectedOrderGrandTotal = orderGoodsTotal+shippingPrice+VAT;
        DecimalFormat formatter = new DecimalFormat("#.00");
        expectedOrderGrandTotal = Double.valueOf(formatter.format(expectedOrderGrandTotal));
        if(orderGrandTotal == expectedOrderGrandTotal){
            value = true;
        }
        return value;
    }

    public void enterGuestCheckoutEmail(String email){
        waitClearAndEnterText(guestEmail).sendKeys(email);
    }

    public void clickGuestCheckoutBtn(){
        clickElementUsingJavascriptExecutor(waitForExpectedElement(guestCheckoutBtn));
    }
}
