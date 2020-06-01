package en.via.SEP4.Model.DBModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "archive", schema = "archive")
public class ArchiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "optimalValues_id")
    private OptimalValuesEntity optimalValuesEntity;
}
