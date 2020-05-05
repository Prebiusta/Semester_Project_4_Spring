package en.via.SEP4.DAO;

import en.via.SEP4.Model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementDao extends JpaRepository<Measurement, Long> {
}
