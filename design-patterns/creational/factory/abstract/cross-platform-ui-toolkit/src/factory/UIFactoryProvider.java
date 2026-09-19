package src.factory;

import src.factory.os.LinuxFactory;
import src.factory.os.MacOSFactory;
import src.factory.os.WindowsFactory;

public class UIFactoryProvider {

    public static UIFactory getUIFactory(String platform){

        if(platform == null || platform.isBlank()){
            throw new IllegalArgumentException("Invalid platform: Cannot be empty");
        }

        return switch (platform.toUpperCase()){

            case "WINDOWS" -> new WindowsFactory();
            case "LINUX" -> new LinuxFactory();
            case "MACOS" -> new MacOSFactory();
            default -> throw new IllegalArgumentException("Invalid platform: " + platform);
        };
    }
}
