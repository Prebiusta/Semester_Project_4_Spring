package en.via.SEP4.Service;

import en.via.SEP4.DAO.ArchiveDao;
import en.via.SEP4.DAO.CarbonDioxideDao;
import en.via.SEP4.Model.DBModel.CarbonDioxideEntity;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CarbonDioxideServiceImpl implements CarbonDioxideService {
    private final CarbonDioxideDao carbonDioxideDao;
    private final ArchiveDao archiveDao;

    @Autowired
    public CarbonDioxideServiceImpl(CarbonDioxideDao carbonDioxideDao, ArchiveDao archiveDao) {
        this.carbonDioxideDao = carbonDioxideDao;
        this.archiveDao = archiveDao;
    }

    @Override
    public CarbonDioxideEntity addCarbonDioxideMeasurementToArchive(Long archiveId, CarbonDioxideEntity carbonDioxideMeasurement) {
        return archiveDao.findById(archiveId).map(archive -> {
            carbonDioxideMeasurement.setArchiveEntity(archive);
            return carbonDioxideDao.save(carbonDioxideMeasurement);
        }).orElseThrow(() -> new ResourceNotFoundException("ArchiveId " + archiveId + " not found"));
    }

    @Override
    public Page<CarbonDioxideEntity> getAllCarbonDioxideMeasurementsFromArchiveId(Long archiveId, Pageable pageable) {
        return carbonDioxideDao.findByArchiveEntityId(archiveId, pageable);
    }

    @Override
    public Page<CarbonDioxideEntity> getCarbonDioxideMeasurementsByDate(Long archiveId, Date date, Pageable pageable) {
        return carbonDioxideDao.findByArchiveEntityIdAndDate(archiveId, date, pageable);
    }

    @Override
    public Page<CarbonDioxideEntity> getCarbonDioxideMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate, Pageable pageable) {
        return carbonDioxideDao.findByArchiveEntityIdAndDateBetween(archiveId, startDate, endDate, pageable);
    }
}
