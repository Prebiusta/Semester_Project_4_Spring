package en.via.SEP4.Service;

import en.via.SEP4.DAO.DatabaseDAO.ArchiveDao;
import en.via.SEP4.Model.DBModel.ArchiveEntity;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveServiceImpl implements ArchiveService {
    private final ArchiveDao archiveDao;

    @Autowired
    public ArchiveServiceImpl(ArchiveDao archiveDao) {
        this.archiveDao = archiveDao;
    }

    @Override
    public List<ArchiveEntity> getAllArchives() {
        return archiveDao.findAll();
    }

    @Override
    public ArchiveEntity getArchiveByArchiveId(Long archiveId) {
        return archiveDao.findById(archiveId).orElseThrow(() -> new ResourceNotFoundException("ArchiveId " + archiveId + " not found"));
    }
}
