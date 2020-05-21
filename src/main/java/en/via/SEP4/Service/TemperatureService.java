package en.via.SEP4.Service;

import en.via.SEP4.Model.DBModel.TemperatureEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface TemperatureService {
    TemperatureEntity addTemperatureMeasurementToArchive(Long archiveId, TemperatureEntity temperatureMeasurement);
    Page<TemperatureEntity> getAllTemperatureMeasurementsFromArchiveId(Long archiveId, Pageable pageable);
    Page<TemperatureEntity> getTemperatureMeasurementsByDate(Long archiveId, Date date, Pageable pageable);
    // TODO: Extract startDate and endDate to separate object
    Page<TemperatureEntity> getTemperatureMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate, Pageable pageable);
}
