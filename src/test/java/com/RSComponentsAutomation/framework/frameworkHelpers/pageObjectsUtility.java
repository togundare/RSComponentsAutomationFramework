package com.RSComponentsAutomation.framework.frameworkHelpers;

import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.RSComponentsAutomation.framework.frameworkHelpers.webDriverHelper.buildChromeBrowser;
import static com.RSComponentsAutomation.framework.frameworkHelpers.webDriverHelper.buildFireFoxBrowser;
import static com.RSComponentsAutomation.framework.frameworkHelpers.webDriverHelper.buildIEBrowser;

public class pageObjectsUtility {
    @Getter
    protected WebDriverWait wait;
    @Getter
    protected WebDriver driver;

    protected static final Logger LOG = LoggerFactory.getLogger(pageObjectsUtility.class);

    protected String winHandle;

    Properties prop = new Properties();

    private By surveyPopup = By.cssSelector("#acsMainInvite");
    private By declineSurveyPopup = By.cssSelector("#acsMainInvite > div > a.acsInviteButton.acsDeclineButton");
    private String browser;

    public void waitForSurveyPopupAndClose(){
        try {
            WebDriverWait wait = new WebDriverWait(driver,1);
            wait.until(ExpectedConditions.visibilityOfElementLocated(surveyPopup));
            driver.findElement(declineSurveyPopup).click();
        } catch (Throwable e) {

        }
    }

     protected pageObjectsUtility() {
        this.driver = webDriverHelper.getWebDriver();
        this.wait = new WebDriverWait(driver, 30);
    }

    protected WebElement waitForExpectedElement(final By by){
         waitForSurveyPopupAndClose();
         return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    {
        try {
            browser = getDataFromConfig("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startHomepage() throws Throwable {
        if (driver == null) {
                if(browser.equalsIgnoreCase("chrome")) {
                    driver = buildChromeBrowser();
                }else if(browser.equalsIgnoreCase("firefox")){
                    driver = buildFireFoxBrowser();
                }else if(browser.equalsIgnoreCase("ie")){
                    driver = buildIEBrowser();
                }
            }
            driver.navigate().to(getDataFromLocale("uk.homeurl"));
    }

    public Actions startActions(){
        Actions act = new Actions(driver);
        return act;
    }

    public List<WebElement> visibilityOfAllElementsLocatedBy(final By by){
        return wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void selectByText(WebElement ele, String text){
        Select selectFromDropdown = new Select(ele);
        selectFromDropdown.selectByVisibleText(text);
    }

    public void clickElementUsingJavascriptExecutor(WebElement ele){
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", ele);
    }

    public Double TrimPoundAndConvertToDouble(String value){
        String Value = value.replaceAll("\\£|(?<=\\d),(?=\\d)", "");
        double newValue = Double.parseDouble(Value);
        DecimalFormat formatter = new DecimalFormat("#.00");
        return Double.valueOf(formatter.format(newValue));
    }

    public String getDataFromLocale(String key) throws IOException {
        prop.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\locales\\uk.properties"));
        return prop.getProperty(key);
    }

    public String getDataFromConfig(String key) throws IOException {
        prop.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\properties\\config.properties"));
        return prop.getProperty(key);
    }

    protected WebElement waitClearAndEnterText(final By by) {
        waitForExpectedElement(by).clear();
        return waitForExpectedElement(by);
    }

    public void handleModalDialog(WebElement ele) {
        winHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        System.out.println("WINDOWS = "+handles.size());
        Iterator<String> ite = handles.iterator();
        while (ite.hasNext()) {
            String popupHandle = ite.next();
            if (!popupHandle.equalsIgnoreCase(winHandle)) {
                driver.switchTo().window(popupHandle);
                clickElementUsingJavascriptExecutor(ele);
                driver.switchTo().window(winHandle);
            }
        }

    }

    public void timeUnitWait(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            LOG.info(e.getMessage());
        }
    }
}
