package en.via.SEP4.Controllers;

import en.via.SEP4.Model.Utility.LatestValues;
import en.via.SEP4.Service.ArchiveService;
import en.via.SEP4.Service.LatestValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LatestValuesController {
    LatestValuesService latestValuesService;
    ArchiveService archiveService;

    @Autowired
    public LatestValuesController(LatestValuesService service, ArchiveService archiveService)
    {
        this. latestValuesService = service;
        this.archiveService = archiveService;
    }

    @GetMapping(value = "archive/{archiveId}/latestValuesByArchiveId")
    ResponseEntity<LatestValues> getTheLatestMeasurementValuesByArchiveId(@PathVariable(value = "archiveId") Long archiveId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(latestValuesService.getTheLatestMeasurementValues(archiveService.getArchiveByArchiveId(archiveId)));
    }

    @GetMapping(value = "archive/latestValues")
    ResponseEntity<List<LatestValues>> getTheLatestMeasurementValuesForAllArchives()
    {

        return ResponseEntity.status(HttpStatus.OK).body(latestValuesService.getTheLatestMeasurementsForAllArchives());
    }
}
