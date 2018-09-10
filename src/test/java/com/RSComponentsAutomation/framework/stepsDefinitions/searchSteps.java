package com.RSComponentsAutomation.framework.stepsDefinitions;

import com.RSComponentsAutomation.framework.models.searchFiltersModel;
import com.RSComponentsAutomation.framework.pageObjects.homePage;
import com.RSComponentsAutomation.framework.pageObjects.searchPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import static org.junit.Assert.assertTrue;


public class searchSteps {

    private homePage HomePage;
    private searchPage SearchPage;
    private searchFiltersModel SearchFiltersModel;

    public searchSteps(homePage homePage, searchPage searchPage, searchFiltersModel searchFiltersModel){
        this.HomePage = homePage;
        this.SearchPage = searchPage;
        this.SearchFiltersModel = searchFiltersModel;
    }

    @And("^I (?:apply|apply another) filter for '(.*)' '(.*)'$")
    public void iApplyAFilter(String subCategory, String mainCategory) throws InterruptedException {
        SearchPage.selectAFilterMainCategory(mainCategory);

        String FilteredProducts = SearchPage.getNumberOfProductsForAFilter(subCategory).replaceAll("\\p{P}","");
        SearchFiltersModel.setNumberOfProductFiltered(FilteredProducts);

        SearchPage.selectASubCategory(subCategory);
        SearchPage.clickApplyFiltersBtn();
        SearchFiltersModel.setFilterSubCategory(subCategory);
    }

    @And("^I verify the total search results for the applied filter$")
    public void iVerifyTotalSearchResults(){
        assertTrue(SearchPage.getNumberOfFilteredResults().endsWith(SearchFiltersModel.getNumberOfProductFiltered()+" products"));
    }

    @Then("^I verify filter is present in filters breadcrumbs$")
    public void iVerifyFilterIsApplied(){
        String appliedFilter = SearchFiltersModel.getFilterSubCategory();
        assertTrue(SearchPage.isFilterApplied(appliedFilter));
    }

    @And("^I verify displayed results are correct$")
    public void iVerifyDisplayedResutsAreCorrect(){
        String appliedFilter = SearchFiltersModel.getFilterSubCategory();
        assertTrue(SearchPage.isItemsDescriptionCorrectForBrandFilters(appliedFilter));
    }

    @When("^I remove all filters$")
    public void iRemoveAllFilters(){
        SearchPage.clickRemoveAllFilters();
    }

    @Then("^I verify all filters is moved$")
    public void iVerifyAllFiltersIsRemoved(){
        SearchPage.timeUnitWait(1);
        assertTrue(SearchPage.checkAllFilterIsCleared());
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) SearchPage.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
    }
}
