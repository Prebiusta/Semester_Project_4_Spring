package en.via.SEP4.Service;

import java.awt.print.Pageable;
import java.util.Date;

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
