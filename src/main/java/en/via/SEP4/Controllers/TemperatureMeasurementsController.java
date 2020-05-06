package en.via.SEP4.Controllers;

import en.via.SEP4.Model.Temperature;
import en.via.SEP4.Service.ArchiveService;
import en.via.SEP4.Service.TemperatureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping(value = "archives/{archiveId}/temperatures")
    public Page<Temperature> getTemperaturesByArchiveId(@PathVariable(name = "archiveId") Long archiveId,
                                                        Pageable pageable) {
        return temperatureService.getAllTemperatureMeasurementsFromArchiveId(archiveId, pageable);
    }

    @PostMapping(value = "archives/{archiveId}/temperatures")
    public Temperature createTemperatureForArchive(@PathVariable(value = "archiveId") Long archiveId,
                                                   @Valid @RequestBody Temperature temperature) {
        return temperatureService.addTemperatureMeasurementToArchive(archiveId, temperature);
    }

    @GetMapping(value = "archives/{archiveId}/temperatures/date")
    public Page<Temperature> getTemperaturesByDate(@PathVariable(name = "archiveId") Long archiveId, @Valid @RequestParam(name = "specificDate") Date date,
                                                   Pageable pageable) {
        return temperatureService.getTemperatureMeasurementsByDate(archiveId, date, pageable);
    }


    @GetMapping(value = "archives/{archiveId}/temperatures/dateInterval")
    public Page<Temperature> getTemperaturesByDateInterval(@PathVariable(name = "archiveId") Long archiveId, @Valid @RequestParam(name = "startDate") Date startDate, @Valid @RequestParam(name = "endDate") Date endDate, Pageable pageable) {
        return temperatureService.getTemperatureMeasurementsByDateInterval(archiveId, startDate, endDate, pageable);
    }


}
