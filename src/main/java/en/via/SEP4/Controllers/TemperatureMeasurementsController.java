package en.via.SEP4.Controllers;

import en.via.SEP4.Model.Temperature;
import en.via.SEP4.Service.ArchiveService;
import en.via.SEP4.Service.TemperatureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class TemperatureMeasurementController {
    private final TemperatureService temperatureService;
    private final ArchiveService archiveService;

    public TemperatureMeasurementController(TemperatureService temperatureService, ArchiveService archiveService) {
        this.temperatureService = temperatureService;
        this.archiveService = archiveService;
    }

    @GetMapping(value = "archives/{archiveId}/temperatures")
    public Page<Temperature> getAllTemperaturesByArchiveId(@PathVariable (name = "archiveId") Long archiveId,
                                                           Pageable pageable) {
        return temperatureService.getAllTemperaturesByArchiveId(archiveId, pageable);
    }

    @PostMapping(value = "archives/{archiveId}/temperatures")
    public Temperature createTemperatureForArchive(@PathVariable(value = "archiveId") Long archiveId,
                                             @Valid @RequestBody Temperature temperature) {
        return temperatureService.addTemperature(archiveId, temperature);
    }
}
