package src.factory.os;

import src.factory.UIFactory;
import src.model.Button;
import src.model.Checkbox;
import src.model.TextField;
import src.model.button.LinuxButton;
import src.model.checkbox.LinuxCheckbox;
import src.model.textfield.LinuxTextField;

public class LinuxFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new LinuxCheckbox();
    }

    @Override
    public TextField createTextField() {
        return new LinuxTextField();
    }
}
