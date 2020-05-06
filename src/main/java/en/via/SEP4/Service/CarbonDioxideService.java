package en.via.SEP4.Service;

import en.via.SEP4.Model.CarbonDioxide;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Date;

public interface CarbonDioxideService {
    // TODO: Create Carbon Dioxide Model
    CarbonDioxide addCarbonDioxideMeasurementToArchive(Long archiveId, CarbonDioxide carbonDioxideMeasurement);
    Page<CarbonDioxide> getAllCarbonDioxideMeasurementsFromArchiveId(Long archiveId, Pageable pageable);
    Page<CarbonDioxide> getCarbonDioxideMeasurementsByDate(Long archiveId, Date date, Pageable pageable);
    // TODO: Extract startDate and endDate to separate object
    Page<CarbonDioxide> getCarbonDioxideMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate, Pageable pageable);
}
