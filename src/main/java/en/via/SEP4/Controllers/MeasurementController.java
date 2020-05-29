package en.via.SEP4.Controllers;

import en.via.SEP4.Model.Utility.MeasurementValues;
import en.via.SEP4.Service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class MeasurementController {
    private final MeasurementService measurementService;

    @Autowired
    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping
    @RequestMapping("archive/measurementValues")
    public ResponseEntity<?> createNewMeasurements(@Valid @RequestBody MeasurementValues measurementValues) {
        return ResponseEntity.status(HttpStatus.CREATED).body(measurementService.saveNewMeasurement(measurementValues));
    }
}
