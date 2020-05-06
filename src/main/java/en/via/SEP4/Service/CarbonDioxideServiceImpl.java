package en.via.SEP4.Service;

import en.via.SEP4.Model.CarbonDioxide;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CarbonDioxideServiceImpl implements CarbonDioxideService {
    @Override
    public CarbonDioxide addCarbonDioxideMeasurementToArchive(Long archiveId, CarbonDioxide carbonDioxideMeasurement) {
        return null;
    }

    @Override
    public Page<CarbonDioxide> getAllCarbonDioxideMeasurementsFromArchiveId(Long archiveId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<CarbonDioxide> getCarbonDioxideMeasurementsByDate(Long archiveId, Date date, Pageable pageable) {
        return null;
    }

    @Override
    public Page<CarbonDioxide> getCarbonDioxideMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate, Pageable pageable) {
        return null;
    }
}
