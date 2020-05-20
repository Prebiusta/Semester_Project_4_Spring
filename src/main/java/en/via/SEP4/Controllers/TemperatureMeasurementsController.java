package en.via.SEP4.Controllers;

import en.via.SEP4.Model.Temperature;
import en.via.SEP4.Service.ArchiveService;
import en.via.SEP4.Service.TemperatureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class TemperatureMeasurementsController {
    private final TemperatureService temperatureService;

    public TemperatureMeasurementsController(TemperatureService temperatureService, ArchiveService archiveService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping(value = "archive/{archiveId}/temperature")
    public Page<Temperature> getTemperaturesByArchiveId(@PathVariable(name = "archiveId") Long archiveId,
                                                        Pageable pageable) {
        return temperatureService.getAllTemperatureMeasurementsFromArchiveId(archiveId, pageable);
    }

    @PostMapping(value = "archive/{archiveId}/temperature")
    public Temperature createTemperatureForArchive(@PathVariable(value = "archiveId") Long archiveId,
                                                   @Valid @RequestBody Temperature temperature) {
        return temperatureService.addTemperatureMeasurementToArchive(archiveId, temperature);
    }

    @GetMapping(value = "archive/{archiveId}/temperature/date")
    public Page<Temperature> getTemperaturesByDate(@PathVariable(name = "archiveId") Long archiveId, @Valid @RequestParam(name = "specificDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date date,
                                                   Pageable pageable) {
        return temperatureService.getTemperatureMeasurementsByDate(archiveId, date, pageable);
    }


    @GetMapping(value = "archive/{archiveId}/temperature/dateInterval")
    public Page<Temperature> getTemperaturesByDateInterval(@PathVariable(name = "archiveId") Long archiveId,
                                                           @Valid @RequestParam(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                           @Valid @RequestParam(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                                           Pageable pageable) {
        return temperatureService.getTemperatureMeasurementsByDateInterval(archiveId, startDate, endDate, pageable);
    }


}
