package src.factory.os;

import src.factory.UIFactory;
import src.model.Button;
import src.model.Checkbox;
import src.model.TextField;
import src.model.button.MacOSButton;
import src.model.checkbox.MacOSCheckbox;
import src.model.textfield.MacOSTextField;

public class MacOSFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }

    @Override
    public TextField createTextField() {
        return new MacOSTextField();
    }
}
