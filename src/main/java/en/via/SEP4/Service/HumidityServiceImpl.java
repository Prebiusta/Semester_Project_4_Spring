package en.via.SEP4.Service;

import en.via.SEP4.DAO.DatabaseDAO.ArchiveDao;
import en.via.SEP4.DAO.DatabaseDAO.HumidityDao;
import en.via.SEP4.Model.DBModel.HumidityEntity;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class HumidityServiceImpl implements HumidityService {
    private final HumidityDao humidityDao;
    private final ArchiveDao archiveDao;

    @Autowired
    public HumidityServiceImpl(HumidityDao humidityDao, ArchiveDao archiveDao) {
        this.humidityDao = humidityDao;
        this.archiveDao = archiveDao;
    }

    @Override
    public HumidityEntity addHumidityMeasurementToArchive(Long archiveId, HumidityEntity humidityMeasurement) {
        return archiveDao.findById(archiveId).map(archive -> {
            humidityMeasurement.setArchiveEntity(archive);
            return humidityDao.save(humidityMeasurement);
        }).orElseThrow(() -> new ResourceNotFoundException("ArchiveId " + archiveId + " not found"));
    }

    @Override
    public List<HumidityEntity> getAllHumidityMeasurementsFromArchiveId(Long archiveId) {
        return humidityDao.findByArchiveEntityId(archiveId);
    }

    @Override
    public List<HumidityEntity> getHumidityMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate) {
        return humidityDao.findByArchiveEntityIdAndDateBetween(archiveId, startDate, endDate);
    }

    @Override
    public float getAverageHumidityMeasurementForArchiveByDateInterval(Long archiveId, Date startDate, Date endDate) {
        return 0;
    }
}
