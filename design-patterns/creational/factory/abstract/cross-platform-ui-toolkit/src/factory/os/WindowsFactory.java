package src.factory.os;

import src.factory.UIFactory;
import src.model.Button;
import src.model.Checkbox;
import src.model.TextField;
import src.model.button.WindowsButton;
import src.model.checkbox.WindowsCheckbox;
import src.model.textfield.WindowsTextField;

public class WindowsFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }

    @Override
    public TextField createTextField() {
        return new WindowsTextField();
    }
}
