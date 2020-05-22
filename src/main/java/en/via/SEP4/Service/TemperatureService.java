package en.via.SEP4.Service;

import en.via.SEP4.Model.DBModel.TemperatureEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface TemperatureService {
    TemperatureEntity addTemperatureMeasurementToArchive(Long archiveId, TemperatureEntity temperatureMeasurement);
    TemperatureEntity getAllTemperatureMeasurementsFromArchiveId(Long archiveId);
    // TODO: Extract startDate and endDate to separate object
    TemperatureEntity getTemperatureMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate);
}
