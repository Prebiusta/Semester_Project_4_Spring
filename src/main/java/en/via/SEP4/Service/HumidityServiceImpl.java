package en.via.SEP4.Service;

import en.via.SEP4.DAO.ArchiveDao;
import en.via.SEP4.DAO.HumidityDao;
import en.via.SEP4.Model.DBModel.HumidityEntity;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Date;

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
    public HumidityEntity getAllHumidityMeasurementsFromArchiveId(Long archiveId) {
        return humidityDao.findByArchiveEntityId(archiveId);
    }

    @Override
    public HumidityEntity getHumidityMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate) {
        return humidityDao.findByArchiveEntityIdAndDateBetween(archiveId, startDate, endDate);
    }
}
