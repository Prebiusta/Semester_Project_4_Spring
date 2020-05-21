package en.via.SEP4.Model.DBModel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
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
    public static String SENSOR_TYPE_CARBON_DIOXIDE = "CarbonDioxide";
}
