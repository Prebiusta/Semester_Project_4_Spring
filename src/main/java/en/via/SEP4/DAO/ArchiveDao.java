package en.via.SEP4.DAO;

import en.via.SEP4.Model.Archive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchiveDao extends JpaRepository<Archive, Long> {
}
