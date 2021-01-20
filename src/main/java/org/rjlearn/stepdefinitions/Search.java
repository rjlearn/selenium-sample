package org.rjlearn.stepdefinitions;

import io.cucumber.java8.En;
import org.rjlearn.page.HomePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Search implements En {
    private HomePage homePage;

    public Search() {
        homePage = new HomePage();

        Given("User is on {string}", (String url) -> {
            homePage.goToUrl(url);
        });

        When("User searches with string {string}", (String searchText) -> {
            homePage.searchWithText(searchText);
        });

        Then("Instant search results should in the search keyword {string}", (String searchText) -> {
            List<String> actualData = homePage.getInstantResultOptions();
            assertThat(actualData).isNotEmpty().allMatch(data -> data.toLowerCase().contains(searchText.toLowerCase()));
        });
    }
}
