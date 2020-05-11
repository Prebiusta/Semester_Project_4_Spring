package en.via.SEP4.Model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "archive", schema = "archive")
public class Archive  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "optimalValues_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private OptimalValues optimalValues;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OptimalValues getOptimalValues() {
        return optimalValues;
    }

    public void setOptimalValues(OptimalValues optimalValues) {
        this.optimalValues = optimalValues;
    }
}
