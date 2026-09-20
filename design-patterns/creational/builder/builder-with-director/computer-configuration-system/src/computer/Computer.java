package src.computer;

public class Computer {

    private final String processor;
    private final String ram;
    private final String storage;
    private final String graphicsCard;
    private final String operatingSystem;
    private final boolean wifiSupport;

     Computer(ComputerBuilder builder) {

        this.processor = builder.processor;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.operatingSystem = builder.operatingSystem;
        this.wifiSupport = builder.wifiSupport;
    }

    public String getProcessor() {
        return processor;
    }

    public String getRam() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public boolean isWifiSupport() {
        return wifiSupport;
    }

    @Override
    public String toString() {

        String str = "{" +
                "\n\tProcessor: " + processor +
                "\n\tRam: " + ram +
                "\n\tStorage: " + storage +
                "\n\tGraphics Card: " + graphicsCard +
                "\n\tOperating System: " + operatingSystem +
                "\n\tWifi Support: " + (wifiSupport ? "Yes" : "No") +
                "\n}\n";
        return str;
    }
}