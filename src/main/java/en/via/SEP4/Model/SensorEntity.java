package en.via.SEP4.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sensor",schema = "archive")
public class SensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String type;

    @Transient
    public static String SENSOR_TYPE_TEMPERATURE = "Temperature";
    @Transient
    public static String SENSOR_TYPE_HUMIDITY = "Humidity";
    @Transient
    public static String SENSOR_TYPE_CARBONDIOXIDE = "CarbonDioxide";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
