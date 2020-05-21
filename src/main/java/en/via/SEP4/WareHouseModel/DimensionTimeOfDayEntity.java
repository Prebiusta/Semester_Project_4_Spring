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
@Table(name = "D_TimeOfDay",schema = "archive_warehouse")
public class DimensionTimeOfDayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dim_time_id")
    private Long id;

    @NotNull
    private int minutesSinceMidnight;

    @NotNull
    private String dayStatus;

}
