package en.via.SEP4.Controllers;

import en.via.SEP4.Model.DBModel.CarbonDioxideEntity;
import en.via.SEP4.Service.CarbonDioxideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CarbonDioxideMeasurementsController {
    private final CarbonDioxideService carbonDioxideService;

    @Autowired
    public CarbonDioxideMeasurementsController(CarbonDioxideService carbonDioxideService) {
        this.carbonDioxideService = carbonDioxideService;
    }

    @GetMapping(value = "archive/{archiveId}/carbondioxide")
    public List<CarbonDioxideEntity> getAllCarbonDioxideMeasurementsByArchiveId(@PathVariable(name = "archiveId") Long archiveId) {
        return carbonDioxideService.getAllCarbonDioxideMeasurementsFromArchiveId(archiveId);
    }

    @PostMapping(value = "archive/{archiveId}/carbondioxide")
    public CarbonDioxideEntity createCarbonDioxideMeasurementForArchive(@PathVariable(name = "archiveId") Long archiveId,
                                                                        @Valid @RequestBody CarbonDioxideEntity carbonDioxideEntity) {
        return carbonDioxideService.addCarbonDioxideMeasurementToArchive(archiveId, carbonDioxideEntity);
    }


    @GetMapping(value = "archive/{archiveId}/carbondioxide/dateInterval")
    public List<CarbonDioxideEntity> getCarbonDioxideMeasurementsByDateInterval(@PathVariable(name = "archiveId") Long archiveId, @Valid @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @Valid @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return carbonDioxideService.getCarbonDioxideMeasurementsByDateInterval(archiveId, startDate, endDate);
    }


}
