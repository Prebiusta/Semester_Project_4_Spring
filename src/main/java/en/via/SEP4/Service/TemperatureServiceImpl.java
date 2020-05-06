package en.via.SEP4.Service;

import en.via.SEP4.DAO.ArchiveDao;
import en.via.SEP4.DAO.TemperatureDao;
import en.via.SEP4.Model.Temperature;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TemperatureServiceImpl implements TemperatureService {
    @Autowired
    TemperatureDao temperatureDao;

    @Autowired
    ArchiveDao archiveDao;

    @Override
    public Temperature addTemperatureMeasurementToArchive(Long archiveId, Temperature temperatureMeasurement) {
        return archiveDao.findById(archiveId).map(archive -> {
            temperatureMeasurement.setArchive(archive);
            return temperatureDao.save(temperatureMeasurement);
        }).orElseThrow(() -> new ResourceNotFoundException("ArchiveId " + archiveId + " not found"));
    }

    @Override
    public Page<Temperature> getAllTemperatureMeasurementsFromArchiveId(Long archiveId, Pageable pageable) {
        return temperatureDao.findByArchiveId(archiveId, pageable);
    }

    @Override
    public Page<Temperature> getTemperatureMeasurementsByDate(Long archiveId, Date date, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Temperature> getTemperatureMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate, Pageable pageable) {
        return null;
    }
}
