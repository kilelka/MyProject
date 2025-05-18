package pages;

import components.LoadablePage;
import elements.InputFieldWrapper;
import models.UserCredentials;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends LoadablePage<LoginPage> {

    private static final By USERNAME_INPUT = By.id("field_email");
    private static final By PASSWORD_INPUT = By.id("field_password");
    private static final By LOGIN_BUTTON = By.cssSelector("input[type='submit']");
    private static final By LOGIN_ERROR = By.xpath(".//*[contains(@class, 'login_error')]");

    private final InputFieldWrapper usernameInput = new InputFieldWrapper($(USERNAME_INPUT));
    private final InputFieldWrapper passwordInput = new InputFieldWrapper($(PASSWORD_INPUT));

    public LoginPage() {
        super();
    }

    @Override
    protected void checkLoad() {
        $(USERNAME_INPUT).shouldBe(visible.because("Поле ввода логина должно быть видно"));
        $(PASSWORD_INPUT).shouldBe(visible.because("Поле ввода пароля должно быть видно"));
        $(LOGIN_BUTTON).shouldBe(visible.because("Кнопка входа должна быть видна"), Duration.ofSeconds(20));

    }

    public LoginPage enterUsername(String username) {
        usernameInput.setValue(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public LoginPage login(UserCredentials user) {
        enterUsername(user.getUsername())
                .enterPassword(user.getPassword())
                .clickLogin();
        return this;
    }

    public void clickLogin() {
        $(LOGIN_BUTTON).shouldBe(visible.because("Кнопка входа должна быть видимой")).click();
    }

    public void checkErrorVisible() {
        $(LOGIN_ERROR).shouldBe(visible.because("Должно отображаться сообщение об ошибке логина"));
    }
}
