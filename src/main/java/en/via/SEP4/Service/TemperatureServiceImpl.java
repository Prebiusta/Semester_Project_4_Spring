package en.via.SEP4.Service;

import en.via.SEP4.DAO.ArchiveDao;
import en.via.SEP4.DAO.TemperatureDao;
import en.via.SEP4.Model.DBModel.TemperatureEntity;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public List<TemperatureEntity> getAllTemperatureMeasurementsFromArchiveId(Long archiveId) {
        return temperatureDao.findByArchiveEntityId(archiveId);
    }

    @Override
    public List<TemperatureEntity> getTemperatureMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate) {
        return temperatureDao.findByArchiveEntityIdAndDateBetween(archiveId, startDate, endDate);
    }

}
