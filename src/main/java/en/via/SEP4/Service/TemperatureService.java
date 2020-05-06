package en.via.SEP4.Service;

import en.via.SEP4.DAO.ArchiveDao;
import en.via.SEP4.DAO.TemperatureDao;
import en.via.SEP4.Model.Temperature;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TemperatureService {
    @Autowired
    TemperatureDao temperatureDao;

    @Autowired
    ArchiveDao archiveDao;

    public Page<Temperature> getAllTemperaturesByArchiveId(Long archiveId, Pageable pageable) {
        return temperatureDao.findByArchiveId(archiveId, pageable);
    }

    public Temperature addTemperature(Long archiveId, Temperature temperature) {
        return archiveDao.findById(archiveId).map(archive -> {
            temperature.setArchive(archive);
            return temperatureDao.save(temperature);
        }).orElseThrow(() -> new ResourceNotFoundException("ArchiveId " + archiveId + " not found"));
    }
}
