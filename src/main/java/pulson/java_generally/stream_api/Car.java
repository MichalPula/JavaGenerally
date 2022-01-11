package pulson.java_generally.stream_api;

public class Car {
    private String manufacturer;
    private String color;
    private int year;

    public Car(String manufacturer, String color, int year) {
        this.manufacturer = manufacturer;
        this.color = color;
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("manufacturer='").append(manufacturer).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", year=").append(year);
        sb.append('}');
        return sb.toString();
    }
}
