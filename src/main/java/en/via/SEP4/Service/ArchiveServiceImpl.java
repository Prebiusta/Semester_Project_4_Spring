package en.via.SEP4.Service;

import en.via.SEP4.DAO.ArchiveDao;
import en.via.SEP4.Model.Archive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveServiceImpl implements ArchiveService {
    @Autowired
    ArchiveDao archiveDao;

    @Override
    public List<Archive> getAllArchives() {
        return archiveDao.findAll();
    }

    @Override
    public Archive getArchiveByArchiveId(Long archiveId) {
        return archiveDao.findArchiveById(archiveId);
    }
}
