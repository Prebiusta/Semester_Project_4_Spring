package en.via.SEP4.WareHouseModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "F_Temperature", schema = "archive_warehouse")
public class FactTemperatureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "A_ID")
    private DimensionArchiveEntity archive;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "S_ID")
    private DimensionSensorEntity sensor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "D_ID")
    private DimensionDateEntity date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "T_ID")
    private DimensionTimeOfDayEntity time;

    @NotNull
    private float temperature;
}