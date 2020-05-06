package en.via.SEP4.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "optimal_values", schema = "archive")
public class OptimalValues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private float optimalTemperature;
    @NotNull
    private float optimalHumidity;
    @NotNull
    private float optimalCarbonDioxide;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getOptimalTemperature() {
        return optimalTemperature;
    }

    public void setOptimalTemperature(float optimalTemperature) {
        this.optimalTemperature = optimalTemperature;
    }

    public float getOptimalHumidity() {
        return optimalHumidity;
    }

    public void setOptimalHumidity(float optimalHumidity) {
        this.optimalHumidity = optimalHumidity;
    }

    public float getOptimalCarbonDioxide() {
        return optimalCarbonDioxide;
    }

    public void setOptimalCarbonDioxide(float optimalCarbonDioxide) {
        this.optimalCarbonDioxide = optimalCarbonDioxide;
    }
}
