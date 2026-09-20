package src.computer;

public class ComputerDirector {

    public Computer buildGamingComputer(){
        return new ComputerBuilder()
                .setProcessor("Intel Core i9")
                .setRam("32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4070")
                .setOperatingSystem("Windows 11")
                .setWifiSupport(true)
                .build();
    }

    public Computer buildOfficeComputer(){
        return new ComputerBuilder()
                .setProcessor("Intel Core i5").setRam("16GB")
                .setStorage("512GB SSD")
                .setGraphicsCard("Integrated Graphics")
                .setOperatingSystem("Windows 11")
                .setWifiSupport(true)
                .build();
    }
}
