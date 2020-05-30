package en.via.SEP4.Model.DWModel;

import jdk.jfr.Name;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "D_Sensor",schema = "archive_warehouse")
public class DimensionSensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dim_sensor_id")
    private Long dimSensorId;

    @Column(name = "sensor_id")
    @NotNull
    private Long sensorId;

    @NotNull
    private String type;

    private Date validFrom;

    private Date validTo;

}
