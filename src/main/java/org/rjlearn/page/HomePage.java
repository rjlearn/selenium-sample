package org.rjlearn.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.rjlearn.driver.DriverController;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private static final By SEARCH_INPUT_BY = By.name("q");
    private static final By INSTANT_RESULT_OPTIONS_BY = By.cssSelector(".erkvQe .sbct .sbl1");

    public HomePage goToUrl(String url) {
        DriverController.getDriver().get(url);
        DriverController.getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(SEARCH_INPUT_BY));
        return this;
    }

    public HomePage searchWithText(String searchText) {
        WebElement searchInputElement = DriverController.getDriver().findElement(SEARCH_INPUT_BY);
        searchInputElement.sendKeys(searchText);
        DriverController.getDriverWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(INSTANT_RESULT_OPTIONS_BY));
        return this;
    }

    public List<String> getInstantResultOptions() {
        List<String> instantResultOptions = new ArrayList<>();
        DriverController.getDriver().findElements(INSTANT_RESULT_OPTIONS_BY).forEach(optionElement -> instantResultOptions.add(optionElement.getText()));
        return instantResultOptions;
    }
}
