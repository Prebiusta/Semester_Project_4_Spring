package en.via.SEP4.Controllers;

import en.via.SEP4.Model.Measurement;
import en.via.SEP4.Service.MeasurementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MeasurementController {
    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @RequestMapping(value = "/measurement", method = RequestMethod.GET)
    public ResponseEntity<?> getMeasurement() {
        return ResponseEntity.status(HttpStatus.OK).body(measurementService.getAllMeasurements());
    }

    @RequestMapping(value = "/measurement", method = RequestMethod.POST)
    public ResponseEntity<?> postMeasurement(@RequestBody Measurement measurement) {
        return ResponseEntity.status(HttpStatus.OK).body(measurementService.addMeasurement(measurement));
    }
}
