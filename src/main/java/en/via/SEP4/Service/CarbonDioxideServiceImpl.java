package en.via.SEP4.Service;

import en.via.SEP4.DAO.ArchiveDao;
import en.via.SEP4.DAO.CarbonDioxideDao;
import en.via.SEP4.Model.CarbonDioxide;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CarbonDioxideServiceImpl implements CarbonDioxideService {
    @Autowired
    private CarbonDioxideDao carbonDioxideDao;

    @Autowired
    private ArchiveDao archiveDao;

    @Override
    public CarbonDioxide addCarbonDioxideMeasurementToArchive(Long archiveId, CarbonDioxide carbonDioxideMeasurement) {
        return archiveDao.findById(archiveId).map(archive -> {
            carbonDioxideMeasurement.setArchive(archive);
            return carbonDioxideDao.save(carbonDioxideMeasurement);
        }).orElseThrow(() -> new ResourceNotFoundException("ArchiveId " + archiveId + " not found"));
    }

    @Override
    public Page<CarbonDioxide> getAllCarbonDioxideMeasurementsFromArchiveId(Long archiveId, Pageable pageable) {
        return carbonDioxideDao.findByArchiveId(archiveId, pageable);
    }

    @Override
    public Page<CarbonDioxide> getCarbonDioxideMeasurementsByDate(Long archiveId, Date date, Pageable pageable) {
        return carbonDioxideDao.findByArchiveIdAndCreatedAt(archiveId, date, pageable);
    }

    @Override
    public Page<CarbonDioxide> getCarbonDioxideMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate, Pageable pageable) {
        return carbonDioxideDao.findByArchiveIdAndCreatedAtBetween(archiveId, startDate, endDate, pageable);
    }
}
