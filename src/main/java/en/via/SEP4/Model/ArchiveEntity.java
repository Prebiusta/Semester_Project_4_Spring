package en.via.SEP4.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @OneToOne(optional = false)
    @JoinColumn(name = "optimalValues_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private OptimalValuesEntity optimalValuesEntity;
}
