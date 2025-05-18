package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {

    private final SelenideElement aboutSectionContainer = $(".text-field_cnt");
    private final SelenideElement aboutTextarea = $(".text-field_cnt textarea");
    private final SelenideElement saveButton = $x("//*[@id='hook_Block_AboutUserRB']//button[contains(text(), 'Сохранить')]");
    private final SelenideElement aboutTextBlock = $("[tsid='TextFieldText']");

    public ProfilePage openEditAboutSection() {
        aboutSectionContainer.shouldBe(visible).click();
        aboutTextarea.shouldBe(visible);
        return this;
    }

    public ProfilePage updateAboutMe(String text) {
        aboutTextarea.clear();
        aboutTextarea.setValue(text);
        return this;
    }

    public ProfilePage saveChanges() {
        saveButton.shouldBe(visible).click();
        return this;
    }

    public String getAboutMeText() {
        return aboutTextBlock.shouldBe(visible).getText();
    }
}
