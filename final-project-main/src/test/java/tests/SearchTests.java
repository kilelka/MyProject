package tests;

import models.UserCredentials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LoginPage;
import pages.MainPage;
import pages.SearchPage;

@DisplayName("Тесты поиска на странице")
@Tag("search")
public class SearchTests extends BaseTest {

    private MainPage mainPage;

    @BeforeEach
    void login() {
        UserCredentials user = new UserCredentials(USERNAME, PASSWORD);

        new LoginPage()
                .login(user);

        mainPage = new MainPage();
    }

    @ParameterizedTest
    @MethodSource("data.SearchDataProvider#searchQueries")
    @DisplayName("Поиск по запросу")
    void shouldReturnSearchResults(String query) {
        mainPage.search(query);

        new SearchPage()
                .enterSearchQuery(query)
                .submitSearch();
    }

    @Disabled("Тест временно отключен")
    @Test
    @DisplayName("Поиск с пустым запросом")
    void shouldHandleEmptySearch() {
        mainPage.search("");

        new SearchPage()
                .enterSearchQuery("")
                .submitSearch();
    }
}
