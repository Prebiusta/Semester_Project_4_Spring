package en.via.SEP4.Service;

import en.via.SEP4.DAO.ArchiveDao;
import en.via.SEP4.DAO.CarbonDioxideDao;
import en.via.SEP4.Model.DBModel.CarbonDioxideEntity;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public List<CarbonDioxideEntity> getAllCarbonDioxideMeasurementsFromArchiveId(Long archiveId) {
        return carbonDioxideDao.findByArchiveEntityId(archiveId);
    }

    @Override
    public List<CarbonDioxideEntity> getCarbonDioxideMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate){
        return carbonDioxideDao.findByArchiveEntityIdAndDateBetween(archiveId, startDate, endDate);
    }

    @Override
    public float getAverageCarbonDioxideMeasurementForArchiveByDateInterval(Long archiveId, Date startDate, Date endDate) {
        return 0;
    }
}
