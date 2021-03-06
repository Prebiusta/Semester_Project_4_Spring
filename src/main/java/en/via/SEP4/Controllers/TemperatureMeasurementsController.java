package en.via.SEP4.Controllers;

import en.via.SEP4.Model.DBModel.TemperatureEntity;
import en.via.SEP4.Model.Utility.StatisticsValues;
import en.via.SEP4.Service.ArchiveService;
import en.via.SEP4.Service.TemperatureService;
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
public class TemperatureMeasurementsController {
    private final TemperatureService temperatureService;

    @Autowired
    public TemperatureMeasurementsController(TemperatureService temperatureService, ArchiveService archiveService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping(value = "archive/{archiveId}/temperature")
    public ResponseEntity<List<TemperatureEntity>> getTemperaturesByArchiveId(@PathVariable(name = "archiveId") Long archiveId) {
        return ResponseEntity.status(HttpStatus.OK).body(temperatureService.getAllTemperatureMeasurementsFromArchiveId(archiveId));
    }

    @GetMapping(value = "archive/{archiveId}/temperature/dateInterval")
    public ResponseEntity<List<StatisticsValues>> getTemperaturesByDateInterval(@PathVariable(name = "archiveId") Long archiveId,
                                                                                @Valid @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                                @Valid @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return ResponseEntity.status(HttpStatus.OK).body(temperatureService.getTemperatureMeasurementsByDateInterval(archiveId, startDate, endDate));
    }

    @GetMapping(value = "archive/{archiveId}/averageTemperature/dateInterval")
    public ResponseEntity<?> getAverageTemperatureMeasurementForArchiveByDateInterval(@PathVariable(name = "archiveId") Long archiveId,
                                                                                        @Valid @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                                        @Valid @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate)
    {
        return ResponseEntity.status(HttpStatus.OK).body(temperatureService.getAverageTemperatureMeasurementForArchiveByDateInterval(archiveId,startDate,endDate));

    }


}
