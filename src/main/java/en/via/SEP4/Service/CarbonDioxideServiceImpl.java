package en.via.SEP4.Service;

import java.awt.print.Pageable;
import java.util.Date;

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
