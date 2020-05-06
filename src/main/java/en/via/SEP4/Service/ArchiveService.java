package en.via.SEP4.Service;

import en.via.SEP4.Model.Archive;

import java.util.List;

public interface ArchiveService {
    List<Archive> getAllArchives();
    Archive getArchiveByArchiveId(Long archiveId);
}
