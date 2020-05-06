package en.via.SEP4.Service;

import en.via.SEP4.Model.Temperature;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface TemperatureService {
    Temperature addTemperatureMeasurementToArchive(Long archiveId, Temperature temperatureMeasurement);
    Page<Temperature> getAllTemperatureMeasurementsFromArchiveId(Long archiveId, Pageable pageable);
    Page<Temperature> getTemperatureMeasurementsByDate(Long archiveId, Date date, Pageable pageable);
    // TODO: Extract startDate and endDate to separate object
    Page<Temperature> getTemperatureMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate, Pageable pageable);
}
