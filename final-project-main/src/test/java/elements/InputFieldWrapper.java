package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

public class InputFieldWrapper {
    private final SelenideElement element;

    public InputFieldWrapper(SelenideElement element) {
        this.element = element;
    }

    public InputFieldWrapper setValue(String value) {
        element.shouldBe(visible.because("Поле должно быть видно для ввода")).setValue(value);
        return this;
    }

    public InputFieldWrapper pressEnter() {
        element.pressEnter();
        return this;
    }
}
