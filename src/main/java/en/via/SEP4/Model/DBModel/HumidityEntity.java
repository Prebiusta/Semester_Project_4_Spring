package en.via.SEP4.Model.DBModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "humidity", schema = "archive")
public class HumidityEntity extends MeasurementEntity {
}
