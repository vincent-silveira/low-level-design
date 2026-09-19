package src.model.button;

import src.model.Button;

public class MacOSButton implements Button {

    @Override
    public void render() {
        System.out.println("Rendering macOS Button");
    }
}
