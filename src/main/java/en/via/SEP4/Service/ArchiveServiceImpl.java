package en.via.SEP4.Service;

import en.via.SEP4.DAO.ArchiveDao;
import org.springframework.stereotype.Service;

@Service
public class ArchiveServiceImpl implements ArchiveService {
    private final ArchiveDao archiveDao;

    public ArchiveServiceImpl(ArchiveDao archiveDao) {
        this.archiveDao = archiveDao;
    }
}
