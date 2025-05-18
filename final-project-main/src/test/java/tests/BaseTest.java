package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTest {

    protected static final String BASE_URL = "https://ok.ru/";
    protected static final String USERNAME = "technopol43";
    protected static final String PASSWORD = "technopolisPassword";

    @BeforeEach
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        open(BASE_URL);
    }

    @AfterEach
    public void tearDown() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }
}
