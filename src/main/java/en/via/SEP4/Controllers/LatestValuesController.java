package en.via.SEP4.Controllers;

import en.via.SEP4.Model.Utility.LatestValues;
import en.via.SEP4.Service.LatestValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LatestValuesController {
    LatestValuesService latestValuesService;

    @Autowired
    public LatestValuesController(LatestValuesService service)
    {
        this. latestValuesService = service;
    }

    @GetMapping(value = "archive/{archiveId}/latestValues")
    LatestValues getTheLatestMeasurementValues(@PathVariable(value = "archiveId") Long archiveId)
    {
        return latestValuesService.getTheLatestMeasurementValues(archiveId);
    }
}
