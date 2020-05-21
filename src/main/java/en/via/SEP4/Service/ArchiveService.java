package en.via.SEP4.Service;

import en.via.SEP4.Model.DBModel.ArchiveEntity;

import java.util.List;

public interface ArchiveService {
    List<ArchiveEntity> getAllArchives();
    ArchiveEntity getArchiveByArchiveId(Long archiveId);
}
