package en.via.SEP4.Controllers;

import en.via.SEP4.Model.DBModel.CarbonDioxideEntity;
import en.via.SEP4.Model.Utility.StatisticsValues;
import en.via.SEP4.Service.CarbonDioxideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<CarbonDioxideEntity>> getAllCarbonDioxideMeasurementsByArchiveId(@PathVariable(name = "archiveId") Long archiveId) {
        return ResponseEntity.status(HttpStatus.OK).body(carbonDioxideService.getAllCarbonDioxideMeasurementsFromArchiveId(archiveId));
    }

    @GetMapping(value = "archive/{archiveId}/carbondioxide/dateInterval")
    public ResponseEntity<List<StatisticsValues>> getCarbonDioxideMeasurementsByDateInterval(@PathVariable(name = "archiveId") Long archiveId,
                                                                                             @Valid @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                                             @Valid @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return ResponseEntity.status(HttpStatus.OK).body(carbonDioxideService.getCarbonDioxideMeasurementsByDateInterval(archiveId, startDate, endDate));
    }

    @GetMapping(value = "archive/{archiveId}/averageCarbondioxide/dateInterval")
    public ResponseEntity<?> getAverageCarbonDioxideMeasurementForArchiveByDateInterval(@PathVariable(name = "archiveId") Long archiveId,
                                                                                            @Valid @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                                            @Valid @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate)
    {
        return ResponseEntity.status(HttpStatus.OK).body(carbonDioxideService.getAverageCarbonDioxideMeasurementForArchiveByDateInterval(archiveId,startDate,endDate));

    }

}
