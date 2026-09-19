package src.factory;

import src.model.Button;
import src.model.Checkbox;
import src.model.TextField;

public interface UIFactory {

    Button createButton();

    Checkbox createCheckbox();

    TextField createTextField();
}
