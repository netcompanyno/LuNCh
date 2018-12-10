package lunch.model;

public class Person {

    private String shortName;
    private String serialNumber;

    public Person() {
    }

    public Person(String shortName, String serialNumber) {
        this.shortName = shortName;
        this.serialNumber = serialNumber;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
