package en.via.SEP4.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "humidity", schema = "archive")
public class Humidity extends Measurement {
}
