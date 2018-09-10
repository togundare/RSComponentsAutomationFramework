$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Checkout.feature");
formatter.feature({
  "name": "As a user I want to complete order on RS Components website",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@CheckoutTests"
    },
    {
      "name": "@AllTests"
    }
  ]
});
formatter.scenario({
  "name": "Create order as a registered customer",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@CheckoutTests"
    },
    {
      "name": "@AllTests"
    },
    {
      "name": "@Test-1"
    }
  ]
});
formatter.step({
  "name": "RS Components homepage is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "checkoutSteps.RSComponentsHomepageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am logged in as a customer",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iAmLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "my basket is clear",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.myBasketIsClear()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for \u0027clock\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "checkoutSteps.iSearchForItem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add first product to basket from results list",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iAddFirstProductToBagFromResultsList()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I proceed to basket summary",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iProceedToBasketSummary()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify basket information is correct",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iVerifyBasketInformationIsCorrect()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I proceed to checkout",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iProceedToCheckout()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify saved address is present",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iVerifySavedAddressIsPresent()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I proceed to payment",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iProceedToPayment()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select \u0027MasterCard\u0027 from saved cards",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iSelectFromSavedCards(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I proceed to order review",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iProceedToOrderReview()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify order review page is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "checkoutSteps.iVerifyOrderReviewPageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify order information is correct",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iVerifyOrderInformation()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Create order as a guest customer",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@CheckoutTests"
    },
    {
      "name": "@AllTests"
    },
    {
      "name": "@Test-2"
    }
  ]
});
formatter.step({
  "name": "RS Components homepage is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "checkoutSteps.RSComponentsHomepageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am a guest customer",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iAmAGuestCustomer()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "my basket is clear",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.myBasketIsClear()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for \u0027clock\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "checkoutSteps.iSearchForItem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I change the quantity of first product to \u00272\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iChangeTheQuantity(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add the product to basket from results list",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iAddFirstProductToBagFromResultsList()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I proceed to basket summary",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iProceedToBasketSummary()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify basket information is correct",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iVerifyBasketInformationIsCorrect()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I proceed to checkout as guest",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iProceedToCheckoutAsGuest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add delivery information",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iAddDeliveryInformation()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I proceed to payment",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iProceedToPayment()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add \u0027Visa\u0027 payment details",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iAddPaymentDetails(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I proceed to order review",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iProceedToOrderReview()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify order review page is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "checkoutSteps.iVerifyOrderReviewPageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify order information is correct",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iVerifyOrderInformation()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("src/test/resources/features/SearchFilters.feature");
formatter.feature({
  "name": "As a user I want to filter my search result so I can narrow down to what suits my needs",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@SearchFilterTests"
    },
    {
      "name": "@AllTests"
    }
  ]
});
formatter.scenario({
  "name": "Verify user can apply single filter to search results",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SearchFilterTests"
    },
    {
      "name": "@AllTests"
    },
    {
      "name": "@Test-3"
    }
  ]
});
formatter.step({
  "name": "RS Components homepage is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "checkoutSteps.RSComponentsHomepageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for \u0027monitors\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "checkoutSteps.iSearchForItem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I apply filter for \u0027Samsung\u0027 \u0027Brand\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "searchSteps.iApplyAFilter(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify filter is present in filters breadcrumbs",
  "keyword": "Then "
});
formatter.match({
  "location": "searchSteps.iVerifyFilterIsApplied()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify displayed results are correct",
  "keyword": "And "
});
formatter.match({
  "location": "searchSteps.iVerifyDisplayedResutsAreCorrect()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify the total search results for the applied filter",
  "keyword": "And "
});
formatter.match({
  "location": "searchSteps.iVerifyTotalSearchResults()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify user can apply multiple filters to search results",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SearchFilterTests"
    },
    {
      "name": "@AllTests"
    },
    {
      "name": "@Test-4"
    }
  ]
});
formatter.step({
  "name": "RS Components homepage is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "checkoutSteps.RSComponentsHomepageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for \u0027camera\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "checkoutSteps.iSearchForItem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I apply filter for \u0027Canon\u0027 \u0027Brand\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "searchSteps.iApplyAFilter(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I apply another filter for \u0027Compact\u0027 \u0027Camera Type\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "searchSteps.iApplyAFilter(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify the total search results for the applied filter",
  "keyword": "Then "
});
formatter.match({
  "location": "searchSteps.iVerifyTotalSearchResults()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify user can remove all applied filters",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SearchFilterTests"
    },
    {
      "name": "@AllTests"
    },
    {
      "name": "@Test-5"
    }
  ]
});
formatter.step({
  "name": "RS Components homepage is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "checkoutSteps.RSComponentsHomepageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for \u0027clock\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iSearchForItem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I apply filter for \u0027Analogue\u0027 \u0027Display\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "searchSteps.iApplyAFilter(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I apply another filter for \u0027AA\u0027 \u0027Battery Type\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "searchSteps.iApplyAFilter(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I remove all filters",
  "keyword": "When "
});
formatter.match({
  "location": "searchSteps.iRemoveAllFilters()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify all filters is moved",
  "keyword": "Then "
});
formatter.match({
  "location": "searchSteps.iVerifyAllFiltersIsRemoved()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});