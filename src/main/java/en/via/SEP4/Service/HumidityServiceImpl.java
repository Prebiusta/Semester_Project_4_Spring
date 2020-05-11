package en.via.SEP4.Service;

import en.via.SEP4.DAO.ArchiveDao;
import en.via.SEP4.DAO.HumidityDao;
import en.via.SEP4.Model.Humidity;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Date;

@Service
public class HumidityServiceImpl implements HumidityService {
    @Autowired
    private HumidityDao humidityDao;

    @Autowired
    private ArchiveDao archiveDao;

    @Override
    public Humidity addHumidityMeasurementToArchive(Long archiveId, Humidity humidityMeasurement) {
        return archiveDao.findById(archiveId).map(archive -> {
            humidityMeasurement.setArchive(archive);
            return humidityDao.save(humidityMeasurement);
        }).orElseThrow(() -> new ResourceNotFoundException("ArchiveId " + archiveId + " not found"));
    }

    @Override
    public Page<Humidity> getAllHumidityMeasurementsFromArchiveId(Long archiveId, Pageable pageable) {
        return humidityDao.findByArchiveId(archiveId, pageable);
    }

    @Override
    public Page<Humidity> getHumidityMeasurementsByDate(Long archiveId, Date date, Pageable pageable) {
        return humidityDao.findByArchiveIdAndCreatedAt(archiveId, date, pageable);
    }

    @Override
    public Page<Humidity> getHumidityMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate, Pageable pageable) {
        return humidityDao.findByArchiveIdAndCreatedAtBetween(archiveId, startDate, endDate, pageable);
    }
}
