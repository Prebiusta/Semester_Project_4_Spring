package en.via.SEP4.Service;

import en.via.SEP4.Model.Humidity;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Date;

public interface HumidityService {
    // TODO: Create Humidity Model
    Humidity addHumidityMeasurementToArchive(Long archiveId, Humidity humidityMeasurement);
    Page<Humidity> getAllHumidityMeasurementsFromArchiveId(Long archiveId, Pageable pageable);
    Page<Humidity> getHumidityMeasurementsByDate(Long archiveId, Date date, Pageable pageable);
    // TODO: Extract startDate and endDate to separate object
    Page<Humidity> getHumidityMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate, Pageable pageable);
}
