package tests;

import models.UserCredentials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты профиля пользователя")
@Tag("profile")
public class ProfileTests extends BaseTest {

    private ProfilePage profilePage;

    @BeforeEach
    void loginAndOpenProfile() {
        UserCredentials user = new UserCredentials(USERNAME, PASSWORD);
        new LoginPage().login(user);
        MainPage mainPage = new MainPage();
        profilePage = mainPage.goToProfile();
    }

    @Test
    @DisplayName("Изменение информации 'О себе'")
    void shouldUpdateAboutMeInfo() {
        String newAboutText = "Тестовая информация о себе";

        profilePage
                .openEditAboutSection()
                .updateAboutMe(newAboutText)
                .saveChanges();

        String actualText = profilePage.getAboutMeText();

        assertEquals(newAboutText, actualText, "Ожидаемый текст 'О себе' не совпадает с фактическим");
    }
}
