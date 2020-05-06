package en.via.SEP4.Service;

import en.via.SEP4.Model.Humidity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Date;

@Service
public class HumidityServiceImpl implements HumidityService {
    @Override
    public Humidity addHumidityMeasurementToArchive(Long archiveId, Humidity humidityMeasurement) {
        return null;
    }

    @Override
    public Page<Humidity> getAllHumidityMeasurementsFromArchiveId(Long archiveId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Humidity> getHumidityMeasurementsByDate(Long archiveId, Date date, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Humidity> getHumidityMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate, Pageable pageable) {
        return null;
    }
}
