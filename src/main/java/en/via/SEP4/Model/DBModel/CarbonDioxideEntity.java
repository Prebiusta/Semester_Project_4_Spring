package en.via.SEP4.Model.DBModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "carbondioxide", schema = "archive")
public class CarbonDioxideEntity extends MeasurementEntity {
}
