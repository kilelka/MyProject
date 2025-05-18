package pages;

import components.LoadablePage;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends LoadablePage<MainPage> {

    private static final By FRIENDS_TAB = By.cssSelector(".nav-side a[href*='friends']");
    private static final By SEARCH_INPUT = By.cssSelector("input[placeholder*='Искать на сайте']");
    private static final By TOOLBAR = By.id("topPanel");
    private static final By PROFILE_TAB = By.cssSelector(".nav-side a[href^='/profile/']");


    public MainPage() {
        super();
    }

    @Override
    protected void checkLoad() {
        $(FRIENDS_TAB).shouldBe(visible.because("Кнопка перехода в друзья должна быть видна"));
        $(TOOLBAR).shouldBe(visible.because("Тулбар должен быть виден на главной странице"));
    }

    public FriendsPage clickFriends() {
        $(FRIENDS_TAB).shouldBe(visible.because("Вкладка 'Друзья' должна быть видна перед кликом")).click();
        return new FriendsPage();
    }

    public MainPage search(String query) {
        $(SEARCH_INPUT).setValue(query).pressEnter();
        return this;
    }

    public MainPage checkToolbarVisible() {
        $(TOOLBAR).shouldBe(visible.because("Тулбар должен быть виден на главной странице"));
        return this;
    }

    public MainPage checkFriendsButton() {
        $(FRIENDS_TAB).shouldBe(visible.because("Кнопка перехода в друзья должна быть видна"));
        return this;
    }

    public ProfilePage goToProfile() {
        $(PROFILE_TAB).shouldBe(visible).click();
        return new ProfilePage();
    }
}
