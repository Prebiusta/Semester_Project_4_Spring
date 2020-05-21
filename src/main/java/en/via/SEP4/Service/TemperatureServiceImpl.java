package en.via.SEP4.Service;

import en.via.SEP4.Repository.ArchiveDao;
import en.via.SEP4.Repository.TemperatureDao;
import en.via.SEP4.Model.TemperatureEntity;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TemperatureServiceImpl implements TemperatureService {
    private final TemperatureDao temperatureDao;
    private final ArchiveDao archiveDao;

    @Autowired
    public TemperatureServiceImpl(TemperatureDao temperatureDao, ArchiveDao archiveDao) {
        this.temperatureDao = temperatureDao;
        this.archiveDao = archiveDao;
    }

    @Override
    public TemperatureEntity addTemperatureMeasurementToArchive(Long archiveId, TemperatureEntity temperatureMeasurement) {
        return archiveDao.findById(archiveId).map(archive -> {
            temperatureMeasurement.setArchiveEntity(archive);
            return temperatureDao.save(temperatureMeasurement);
        }).orElseThrow(() -> new ResourceNotFoundException("ArchiveId " + archiveId + " not found"));
    }

    @Override
    public Page<TemperatureEntity> getAllTemperatureMeasurementsFromArchiveId(Long archiveId, Pageable pageable) {
        return temperatureDao.findByArchiveId(archiveId, pageable);
    }

    @Override
    public Page<TemperatureEntity> getTemperatureMeasurementsByDate(Long archiveId, Date date, Pageable pageable) {
        return temperatureDao.findByArchiveIdAndCreatedAt(archiveId, date, pageable);
    }

    @Override
    public Page<TemperatureEntity> getTemperatureMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate, Pageable pageable) {
        return temperatureDao.findByArchiveIdAndCreatedAtBetween(archiveId, startDate, endDate, pageable);
    }
}
