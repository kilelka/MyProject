package tests;

import models.UserCredentials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import pages.FriendsPage;
import pages.LoginPage;
import pages.MainPage;

@DisplayName("Тесты для раздела 'Друзья'")
@Tag("friends")
public class FriendsTests extends BaseTest {

    private MainPage mainPage;
    private FriendsPage friendsPage;

    @BeforeEach
    void login() {
        UserCredentials user = new UserCredentials(USERNAME, PASSWORD);

        new LoginPage()
                .login(user);

        mainPage = new MainPage();
    }

    @Nested
    @DisplayName("Навигация")
    class NavigationTests {

        @Test
        @DisplayName("Переход в раздел 'Друзья'")
        @Timeout(20)
        void shouldNavigateToFriendsSection() {
            friendsPage = mainPage.clickFriends();
        }
    }

    @Nested
    @DisplayName("Поиск")
    class SearchTests {

        @Test
        @DisplayName("Поиск друга по имени")
        @Timeout(40)
        void shouldSearchFriendByName() {
            friendsPage = mainPage.clickFriends();
            friendsPage.search("Иван Иванов")
                    .checkSearchResults();
        }
    }
}
