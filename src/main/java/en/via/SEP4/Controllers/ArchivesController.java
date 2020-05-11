package en.via.SEP4.Controllers;

import en.via.SEP4.Model.Archive;
import en.via.SEP4.Service.ArchiveService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArchivesController {
    ArchiveService archiveService;

    public ArchivesController(ArchiveService archiveService) {
        this.archiveService = archiveService;
    }

    @GetMapping(value = "/archive")
    public List<Archive> getAllArchives() {
        return archiveService.getAllArchives();
    }

    @GetMapping(value = "archive/{archiveId}")
    public Archive getArchiveByArchiveId(@PathVariable(name = "archiveId") Long archiveId
    ) {
        return archiveService.getArchiveByArchiveId(archiveId);
    }
}

