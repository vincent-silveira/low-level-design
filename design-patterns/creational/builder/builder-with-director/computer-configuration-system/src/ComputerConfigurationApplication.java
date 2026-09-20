package src;

import src.computer.Computer;
import src.computer.ComputerBuilder;
import src.computer.ComputerDirector;

public class ComputerConfigurationApplication {

    public static void main(String[] args) {

        ComputerDirector director = new ComputerDirector();

        Computer customComputer = new ComputerBuilder()
                .setProcessor("AMD Ryzen 7")
                .setRam("64GB")
                .setStorage("2TB SSD")
                .setGraphicsCard("AMD Radeon RX 7900")
                .setOperatingSystem("Ubuntu Linux")
                .setWifiSupport(false)
                .build();

        Computer gamingComputer = director.buildGamingComputer();
        Computer officeComputer = director.buildOfficeComputer();

        System.out.println("Custom Computer" + customComputer);
        System.out.println("Gaming Computer" + gamingComputer);
        System.out.println("Office Computer" + officeComputer);



    }

}
