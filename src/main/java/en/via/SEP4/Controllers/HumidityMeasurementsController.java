package en.via.SEP4.Controllers;

import en.via.SEP4.Model.DBModel.HumidityEntity;
import en.via.SEP4.Service.HumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class HumidityMeasurementsController {
    private final HumidityService humidityService;

    @Autowired
    public HumidityMeasurementsController(HumidityService humidityService) {
        this.humidityService = humidityService;
    }

    @GetMapping(value = "archive/{archiveId}/humidity")
    public HumidityEntity getHumidityMeasurementsByArchiveId(@PathVariable(name = "archiveId") Long archiveId) {
        return humidityService.getAllHumidityMeasurementsFromArchiveId(archiveId);
    }

    @PostMapping(value = "archive/{archiveId}/humidity")
    public HumidityEntity createHumidityForArchive(@PathVariable(value = "archiveId") Long archiveId,
                                                   @Valid @RequestBody HumidityEntity humidityEntity) {
        return humidityService.addHumidityMeasurementToArchive(archiveId, humidityEntity);
    }

    @GetMapping(value = "archive/{archiveId}/humidity/date")
    public HumidityEntity getHumidityMeasurementsByDate(@PathVariable(name = "archiveId") Long archiveId, @Valid @RequestParam(name = "specificDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return humidityService.getHumidityMeasurementsByDate(archiveId, date);
    }

    @GetMapping(value = "archive/{archiveId}/humidity/dateInterval")
    public HumidityEntity getHumidityMeasurementsByDateInterval(@PathVariable(name = "archiveId") Long archiveId, @Valid @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @Valid @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return humidityService.getHumidityMeasurementsByDateInterval(archiveId, startDate, endDate);
    }


}
