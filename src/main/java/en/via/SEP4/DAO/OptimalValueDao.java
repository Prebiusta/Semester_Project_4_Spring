package en.via.SEP4.DAO;

import en.via.SEP4.Model.DBModel.OptimalValuesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptimalValueDao extends JpaRepository<OptimalValuesEntity, Long> {
}
