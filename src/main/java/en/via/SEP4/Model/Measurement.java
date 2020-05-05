package en.via.SEP4.Model;

public class Measurement {
    private final long id;
    private final float temperature;
    private final float humidity;
    private final float carbonDioxide;

    public Measurement(long id, float temperature, float humidity, float carbonDioxide) {
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.carbonDioxide = carbonDioxide;
    }

    public long getId() {
        return id;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getCarbonDioxide() {
        return carbonDioxide;
    }
}
