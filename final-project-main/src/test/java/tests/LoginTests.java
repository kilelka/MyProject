package tests;

import models.UserCredentials;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LoginPage;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertAll;

@Tag("auth")
@DisplayName("Тесты на логин")
public class LoginTests extends BaseTest {

    @Nested
    @DisplayName("Позитивные сценарии логина")
    class SuccessfulLoginTests {

        @ParameterizedTest(name = "Успешный логин: {0}")
        @CsvSource({
                "technopol43, technopolisPassword"
        })
        @DisplayName("Успешный логин с правильными данными")
        @Timeout(30)
        void successfulLoginTest(String username, String password) {
            UserCredentials user = new UserCredentials(username, password);

            new LoginPage()
                    .login(user);

            MainPage mainPage = new MainPage();
            assertAll("Проверка успешного входа",
                    () -> mainPage.checkFriendsButton(),
                    () -> mainPage.checkToolbarVisible()
            );
        }
    }

    @Nested
    @DisplayName("Негативные сценарии логина")
    class FailedLoginTests {

        @ParameterizedTest(name = "Неуспешный логин: {0}")
        @CsvSource({
                "wrongUser, wrongPass",
                "emptyUser, ''",
                "'', emptyPass",
                "'', ''"
        })
        @DisplayName("Ошибка логина при неправильных данных")
        @Timeout(30)
        void failedLoginTest(String username, String password) {
            UserCredentials user = new UserCredentials(username, password);

            new LoginPage()
                    .login(user)
                    .checkErrorVisible();
        }
    }
}
