package en.via.SEP4.DAO.DatabaseDAO;

import en.via.SEP4.Model.DBModel.ArchiveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchiveDao extends JpaRepository<ArchiveEntity, Long> {
}
