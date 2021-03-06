package en.via.SEP4.Controllers;

import en.via.SEP4.Model.DBModel.HumidityEntity;
import en.via.SEP4.Model.Utility.StatisticsValues;
import en.via.SEP4.Service.HumidityService;
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
public class HumidityMeasurementsController {
    private final HumidityService humidityService;

    @Autowired
    public HumidityMeasurementsController(HumidityService humidityService) {
        this.humidityService = humidityService;
    }

    @GetMapping(value = "archive/{archiveId}/humidity")
    public ResponseEntity<List<HumidityEntity>> getHumidityMeasurementsByArchiveId(@PathVariable(name = "archiveId") Long archiveId) {
        return ResponseEntity.status(HttpStatus.OK).body(humidityService.getAllHumidityMeasurementsFromArchiveId(archiveId));
    }

    @GetMapping(value = "archive/{archiveId}/humidity/dateInterval")
    public ResponseEntity<List<StatisticsValues>> getHumidityMeasurementsByDateInterval(@PathVariable(name = "archiveId") Long archiveId, @Valid @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @Valid @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return ResponseEntity.status(HttpStatus.OK).body(humidityService.getHumidityMeasurementsByDateInterval(archiveId, startDate, endDate));
    }

    @GetMapping(value = "archive/{archiveId}/averageHumidity/dateInterval")
    public ResponseEntity<?> getAverageHumidityMeasurementForArchiveByDateInterval(@PathVariable(name = "archiveId") Long archiveId,
                                                                                        @Valid @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                                        @Valid @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate)
    {
        return ResponseEntity.status(HttpStatus.OK).body(humidityService.getAverageHumidityMeasurementForArchiveByDateInterval(archiveId,startDate,endDate));

    }


}
