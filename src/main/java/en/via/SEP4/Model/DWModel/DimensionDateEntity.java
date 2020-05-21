package en.via.SEP4.Model.DWModel;

import jdk.jfr.Name;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "D_Date",schema = "archive_warehouse")
public class DimensionDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dim_date_id")
    private Long dimDateId;

    @NotNull
    private Date representedDate;

    @Column(name = "month_name")
    @NotNull
    private String monthName;

    @Column(name = "day_name")
    @NotNull
    private String dayName;
}
