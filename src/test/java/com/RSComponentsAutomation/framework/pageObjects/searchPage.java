package com.RSComponentsAutomation.framework.pageObjects;

import com.RSComponentsAutomation.framework.frameworkHelpers.pageObjectsUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class searchPage extends pageObjectsUtility {

    private By itemsStockNo = By.cssSelector("#results-table > tbody > tr > td.descriptionCol.compareContainer > div:nth-child(3) > a");
    private By itemsPrices = By.cssSelector("#results-table > tbody > tr > td.priceCol > div:nth-child(1) > span");
    private By applyFiltersBtn = By.cssSelector("#filters > div > div > rs-facets > div > div.popover-inner > div > div:nth-child(6) > rs-apply-button > button");
    private By mainCategoriesFilter = By.cssSelector("#filters > div > div > rs-facets > a");
    private By SubCategoriesFilter = By.cssSelector("#filters > div > div > rs-facets > div > div > div > div.clearfix > div > span > div > label > span:nth-child(2)");
    private By subCategoriesNames = By.cssSelector("#filters > div > div > rs-facets > div > div.popover-inner > div > div.clearfix > div > span > div > label > span:nth-child(2) > span");
    private By appliedFilters = By.cssSelector("#bread-box > div.appliedFilters > rs-bread-box > div.row > div.row > div> div");
    private By filteredResults = By.cssSelector("#results-table > tbody > tr > td.descriptionCol.compareContainer > div.row.margin-bottom > a");
    private By numberOfProductsForAFilter = By.cssSelector("#filters > div > div > rs-facets > div > div > div > div.clearfix > div > span > div > label > span:nth-child(2) > span > span");
    private By numberOfFilteredResults = By.cssSelector("#sticky-results-header > rs-pagination > div > div > div:nth-child(1) > div");
    private By removeAllFilters = By.cssSelector("#bread-box > div.appliedFilters > rs-bread-box > div.col-xs-12.noPaddingCol > div > a");


    public void addFirstItemToCartFromSearchResults(){
        waitForExpectedElement(By.cssSelector("#atbBtn-1")).click();
    }

    public void changeFirstItemQuantity(String Qty){ waitClearAndEnterText(By.cssSelector("#atbQty-1")).sendKeys(Qty); }

    public List<WebElement> listNumberOfProductsForAFilter(){ return visibilityOfAllElementsLocatedBy(numberOfProductsForAFilter); }

    public String getNumberOfProductsForAFilter(String subCategory){
        String value = "";
        for(int i=0; i<listNumberOfProductsForAFilter().size(); i++){
            String expectedCategory = getSubcategoryNames().get(i).getText().trim();
            if(expectedCategory.contains(subCategory)){
                value = listNumberOfProductsForAFilter().get(i).getText().trim();
            }
        }
        return value;
    }

    public String getNumberOfFilteredResults(){ return waitForExpectedElement(numberOfFilteredResults).getText().trim(); }

    public String getFirstItemPriceFromSearchResults(){
        String itemPrice = visibilityOfAllElementsLocatedBy(itemsPrices).get(0).getText().trim();
        return itemPrice;
    }

    public void clickRemoveAllFilters(){ waitForExpectedElement(removeAllFilters).click(); }

    public String getFirstItemStockNoFromSearchResults(){
        String itemStockNo = visibilityOfAllElementsLocatedBy(itemsStockNo).get(0).getText().trim();
        return itemStockNo;
    }

    public List<WebElement> getListOfMainCategoriesFilters(){
        return visibilityOfAllElementsLocatedBy(mainCategoriesFilter);
    }

    public List<WebElement> getListOfSubCategoriesFilters(){
        return visibilityOfAllElementsLocatedBy(SubCategoriesFilter);
    }

    public List<WebElement> getSubcategoryNames(){
        return visibilityOfAllElementsLocatedBy(subCategoriesNames);
    }

    public List<WebElement> getItemsDescriptionForFilteredResults(){
        return visibilityOfAllElementsLocatedBy(filteredResults);
    }

    public void selectAFilterMainCategory(String mainCategory) {
        for (int i = 0; i < getListOfMainCategoriesFilters().size(); i++) {
            String Category = getListOfMainCategoriesFilters().get(i).getText().trim();
            if (Category.equalsIgnoreCase(mainCategory)) {
                timeUnitWait(2);
                getListOfMainCategoriesFilters().get(i).click();
                break;
            }
        }
    }

    public void selectASubCategory(String filterSubCategory){
        for(int i=0; i<getSubcategoryNames().size(); i++){
            String subCategory = getSubcategoryNames().get(i).getText().trim();
            if(subCategory.contains(filterSubCategory)){
                getListOfSubCategoriesFilters().get(i).click();
                break;
            }
        }
    }

    public void clickApplyFiltersBtn(){ waitForExpectedElement(applyFiltersBtn).click(); }

    public List<WebElement> getAppliedFilters(){ return visibilityOfAllElementsLocatedBy(appliedFilters); }

    public boolean checkAllFilterIsCleared(){
        return driver.findElements(appliedFilters).isEmpty();
    }

    public boolean isFilterApplied(String subCategory){
        boolean value = false;
        for(int i=0; i< getAppliedFilters().size(); i++){
            String expectedSubCategory = getAppliedFilters().get(i).getText().trim();
            if(expectedSubCategory.contains(subCategory)){
                value = true;
            }
        }
        return value;
    }

    public boolean isItemsDescriptionCorrectForBrandFilters(String subCategory){
        boolean value = false;
        for(int i=0; i< getItemsDescriptionForFilteredResults().size(); i++){
            String itemsDescription = getItemsDescriptionForFilteredResults().get(i).getText().trim();
            if(itemsDescription.contains(subCategory)){
                value = true;
            }
        }
        return value;
    }
}
