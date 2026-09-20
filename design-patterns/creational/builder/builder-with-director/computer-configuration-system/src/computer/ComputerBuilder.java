package src.computer;

public class ComputerBuilder {

     String processor = null;
     String ram = null;
     String storage = null;
     String graphicsCard = null;
     String operatingSystem = null;
     boolean wifiSupport = false;

    public ComputerBuilder setProcessor(String processor){
        this.processor = processor;
        return this;
    }

    public ComputerBuilder setRam(String ram){
        this.ram = ram;
        return this;
    }

    public ComputerBuilder setStorage(String storage){
        this.storage = storage;
        return this;
    }

    public ComputerBuilder setGraphicsCard(String graphicsCard){
        this.graphicsCard = graphicsCard;
        return this;
    }

    public ComputerBuilder setOperatingSystem(String operatingSystem){
        this.operatingSystem = operatingSystem;
        return this;
    }

    public ComputerBuilder setWifiSupport(boolean wifiSupport){
        this.wifiSupport = wifiSupport;
        return this;
    }

    public Computer build(){
        return new Computer(this);
    }

}