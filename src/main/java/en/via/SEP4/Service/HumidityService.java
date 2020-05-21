package en.via.SEP4.Service;

import en.via.SEP4.Model.HumidityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface HumidityService {
    // TODO: Create Humidity Model
    HumidityEntity addHumidityMeasurementToArchive(Long archiveId, HumidityEntity humidityMeasurement);
    Page<HumidityEntity> getAllHumidityMeasurementsFromArchiveId(Long archiveId, Pageable pageable);
    Page<HumidityEntity> getHumidityMeasurementsByDate(Long archiveId, Date date, Pageable pageable);
    // TODO: Extract startDate and endDate to separate object
    Page<HumidityEntity> getHumidityMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate, Pageable pageable);
}
