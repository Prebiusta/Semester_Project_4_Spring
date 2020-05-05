package en.via.SEP4.Model;

import javax.persistence.*;

@Entity
@Table(name = "measurement", schema = "archive")
public class Measurement {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "temperature", nullable = true, length = 100)
    private float temperature;

    @Column(name = "humidity", nullable = true, length = 100)
    private float humidity;

    @Column(name = "carbonDioxide", nullable = true, length = 100)
    private float carbonDioxide;

    public Measurement() {
    }

    public Measurement(long id, float temperature, float humidity, float carbonDioxide) {
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.carbonDioxide = carbonDioxide;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getCarbonDioxide() {
        return carbonDioxide;
    }

    public void setCarbonDioxide(float carbonDioxide) {
        this.carbonDioxide = carbonDioxide;
    }
}
