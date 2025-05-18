package pages;

import components.LoadablePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class SearchPage extends LoadablePage<SearchPage> {

    private static final By SEARCH_INPUT = By.cssSelector("portal-search label input");

    public SearchPage() {
        super();
    }

    @Override
    protected void checkLoad() {
        $(SEARCH_INPUT).shouldBe(visible.because("Поле поиска должно быть видно на странице поиска"));
    }


    public SearchPage enterSearchQuery(String query) {
        $(SEARCH_INPUT).setValue(query);
        return this;
    }

    public SearchPage submitSearch() {
        $(SEARCH_INPUT).pressEnter();
        return this;
    }
}
