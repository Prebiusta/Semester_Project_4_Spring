package en.via.SEP4.Controllers;

import en.via.SEP4.Model.Humidity;

import en.via.SEP4.Service.HumidityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class HumidityMeasurementController {
    private final HumidityService humidityService;

    public HumidityMeasurementController(HumidityService humidityService) {
        this.humidityService = humidityService;
    }

    @GetMapping(value = "archives/{archiveId}/humidityMeasurements")
    public Page<Humidity> getHumidityMeasurementsByArchiveId(@PathVariable(name = "archiveId") Long archiveId,
                                                           org.springframework.data.domain.Pageable pageable) {
        return humidityService.getAllHumidityMeasurementsFromArchiveId(archiveId, pageable);
    }

    @PostMapping(value = "archives/{archiveId}/humidityMeasurements")
    public Humidity createTemperatureForArchive(@PathVariable(value = "archiveId") Long archiveId,
                                                   @Valid @RequestBody Humidity humidity) {
        return humidityService.addHumidityMeasurementToArchive(archiveId,humidity);
    }

    @GetMapping(value = "archives/{archiveId}/humidityMeasurements")
    public Page<Humidity> getHumidityMeasurementsByDate(@PathVariable(name = "archiveId") Long archiveId, Date date,
                                                                Pageable pageable) {
        return humidityService.getHumidityMeasurementsByDate(archiveId,date,pageable);
    }

    @GetMapping(value = "archives/{archiveId}/humidityMeasurements")
    public Page<Humidity> getHumidityMeasurementsByDateInterval(@PathVariable(name = "archiveId") Long archiveId, Date startDate, Date endDate,
                                                           Pageable pageable) {
        return humidityService.getHumidityMeasurementsByDateInterval(archiveId,startDate,endDate,pageable);
    }






}
