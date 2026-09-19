package src;

import src.factory.UIFactory;
import src.factory.UIFactoryProvider;
import src.model.Button;
import src.model.Checkbox;
import src.model.TextField;

public class UIApplication {

    public static void main(String[] args) {

        String platform = "WINDOWS";

        UIFactory uiFactory = UIFactoryProvider.getUIFactory(platform);

        Button button = uiFactory.createButton();
        Checkbox checkbox = uiFactory.createCheckbox();
        TextField textField = uiFactory.createTextField();

        button.render();
        checkbox.render();
        textField.render();
    }
}
