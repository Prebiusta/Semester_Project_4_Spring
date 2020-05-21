package en.via.SEP4.Repository;

import en.via.SEP4.Model.ArchiveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchiveDao extends JpaRepository<ArchiveEntity, Long> {
    ArchiveEntity findArchiveById(Long archiveId);
}
