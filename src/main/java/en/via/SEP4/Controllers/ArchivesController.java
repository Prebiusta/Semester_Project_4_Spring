package en.via.SEP4.Controllers;

import en.via.SEP4.Model.DBModel.ArchiveEntity;
import en.via.SEP4.Service.ArchiveService;
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
public class ArchivesController {
    private final ArchiveService archiveService;

    @Autowired
    public ArchivesController(ArchiveService archiveService) {
        this.archiveService = archiveService;
    }

    @GetMapping(value = "/archive")
    public ResponseEntity<List<ArchiveEntity>> getAllArchives() {
        return ResponseEntity.status(HttpStatus.OK).body(archiveService.getAllArchives()) ;
    }

    @GetMapping(value = "archive/{archiveId}")
    public ResponseEntity<ArchiveEntity> getArchiveByArchiveId(@PathVariable(name = "archiveId") Long archiveId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(archiveService.getArchiveByArchiveId(archiveId));
    }
}

