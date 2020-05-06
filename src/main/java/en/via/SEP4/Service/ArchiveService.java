package en.via.SEP4.Service;

import en.via.SEP4.DAO.ArchiveDao;
import org.springframework.stereotype.Service;

@Service
public class ArchiveService {
    private final ArchiveDao archiveDao;

    public ArchiveService(ArchiveDao archiveDao) {
        this.archiveDao = archiveDao;
    }
}
