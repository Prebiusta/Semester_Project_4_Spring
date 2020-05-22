package en.via.SEP4.Controllers;

import en.via.SEP4.Model.DBModel.ArchiveEntity;
import en.via.SEP4.Model.Utility.LatestValues;
import en.via.SEP4.Service.ArchiveService;
import en.via.SEP4.Service.LatestValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    LatestValues getTheLatestMeasurementValuesByArchiveId(@PathVariable(value = "archiveId") Long archiveId)
    {
        return latestValuesService.getTheLatestMeasurementValues(archiveService.getArchiveByArchiveId(archiveId));
    }

    @GetMapping(value = "archive/latestValues")
    List<LatestValues> getTheLatestMeasurementValuesForAllArchives()
    {

        return latestValuesService.getTheLatestMeasurementsForAllArchives();
    }
}
