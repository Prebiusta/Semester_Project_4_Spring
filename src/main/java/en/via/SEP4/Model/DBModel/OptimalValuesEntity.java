package en.via.SEP4.Model.DBModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "optimal_values", schema = "archive")
public class OptimalValuesEntity {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private float optimalTemperature;

    @NotNull
    private float optimalHumidity;

    @NotNull
    private float optimalCarbonDioxide;
}
