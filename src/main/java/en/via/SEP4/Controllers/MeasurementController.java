package en.via.SEP4.Controllers;

import en.via.SEP4.Model.Measurement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeasurementController {

    @GetMapping("/measurement")
    public Measurement getMeasurement(){
        Measurement m1 = new Measurement(1,12.56f,56, 200);
        return m1;
    }
}
