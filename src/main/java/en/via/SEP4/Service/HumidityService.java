package en.via.SEP4.Service;

import en.via.SEP4.Model.DBModel.HumidityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface HumidityService {
    HumidityEntity addHumidityMeasurementToArchive(Long archiveId, HumidityEntity humidityMeasurement);
    HumidityEntity getAllHumidityMeasurementsFromArchiveId(Long archiveId);
    // TODO: Extract startDate and endDate to separate object
    HumidityEntity getHumidityMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate);
}
