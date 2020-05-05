package en.via.SEP4.DAO;

import en.via.SEP4.Model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeasurementDao extends JpaRepository<Measurement, Long> {
    List<Measurement> findAllByTemperatureGreaterThan(int minTemp);
}
