package en.via.SEP4.Controllers;

import en.via.SEP4.Model.CarbonDioxide;

import en.via.SEP4.Service.CarbonDioxideService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class CarbonDioxideMeasurementsController {
    private final CarbonDioxideService carbonDioxideService;

    public CarbonDioxideMeasurementsController(CarbonDioxideService carbonDioxideService) {
        this.carbonDioxideService = carbonDioxideService;
    }

    @GetMapping(value = "archives/{archiveId}/carbonDioxideMeasurements")
    public Page<CarbonDioxide> getAllCarbonDioxideMeasurementsByArchiveId(@PathVariable(name = "archiveId") Long archiveId,
                                                             Pageable pageable) {
        return carbonDioxideService.getAllCarbonDioxideMeasurementsFromArchiveId(archiveId, pageable);
    }

    @PostMapping(value = "archives/{archiveId}/carbonDioxideMeasurements")
    public CarbonDioxide createCarbonDioxideMeasurementForArchive(@PathVariable(value = "archiveId") Long archiveId,
                                                   @Valid @RequestBody CarbonDioxide carbonDioxide) {
        return carbonDioxideService.addCarbonDioxideMeasurementToArchive(archiveId, carbonDioxide);
    }

    @GetMapping(value = "archives/{archiveId}/carbonDioxideMeasurements")
    public Page<CarbonDioxide> getAllCarbonDioxideMeasurementsByDate(@PathVariable(name = "archiveId") Long archiveId, Date date,
                                                                          Pageable pageable) {
        return carbonDioxideService.getCarbonDioxideMeasurementsByDate(archiveId, date, pageable);
    }

    @GetMapping(value = "archives/{archiveId}/carbonDioxideMeasurements")
    public Page<CarbonDioxide> getCarbonDioxideMeasurementsByDateInterval(@PathVariable(name = "archiveId") Long archiveId, Date startDate, Date endDate,
                                                                          Pageable pageable) {
        return carbonDioxideService.getCarbonDioxideMeasurementsByDateInterval(archiveId, startDate, endDate, pageable);
    }


}
