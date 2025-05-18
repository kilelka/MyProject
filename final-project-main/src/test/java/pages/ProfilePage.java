package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

public class ProfilePage {

    private static final By ABOUT_SECTION_CONTAINER = By.cssSelector(".text-field_cnt");
    private static final By ABOUT_TEXTAREA = By.cssSelector(".text-field_cnt textarea");
    private static final By SAVE_BUTTON = By.xpath("//*[@id='hook_Block_AboutUserRB']//button[contains(text(), 'Сохранить')]");
    private static final By ABOUT_TEXT_BLOCK = By.cssSelector("[tsid='TextFieldText']");

    public ProfilePage openEditAboutSection() {
        $(ABOUT_SECTION_CONTAINER).shouldBe(visible, ofSeconds(15)).click();
        $(ABOUT_TEXTAREA).shouldBe(visible, ofSeconds(15));
        return this;
    }

    public ProfilePage updateAboutMe(String text) {
        $(ABOUT_TEXTAREA).clear();
        $(ABOUT_TEXTAREA).setValue(text);
        return this;
    }

    public ProfilePage saveChanges() {
        $(SAVE_BUTTON).shouldBe(visible).click();
        return this;
    }

    public String getAboutMeText() {
        return $(ABOUT_TEXT_BLOCK).shouldBe(visible).getText();
    }
}
