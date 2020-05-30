package en.via.SEP4.Model.DWModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "F_CarbonDioxide", schema = "archive_warehouse")
public class FactCarbonDioxideEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "A_ID")
    private DimensionArchiveEntity archive;
    @ManyToOne
    @JoinColumn(name = "S_ID")
    private DimensionSensorEntity sensor;
    @ManyToOne
    @JoinColumn(name = "D_ID")
    private DimensionDateEntity date;
    @ManyToOne
    @JoinColumn(name = "T_ID")
    private DimensionTimeOfDayEntity time;

    @NotNull
    private float carbonDioxide;

}
