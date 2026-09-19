package src.model.button;

import src.model.Button;

public class LinuxButton implements Button {

    @Override
    public void render() {
        System.out.println("Rendering Linux Button");
    }
}
