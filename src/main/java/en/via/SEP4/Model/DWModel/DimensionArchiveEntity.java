package en.via.SEP4.Model.DWModel;

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
@Table (name = "D_Archive", schema = "archive_warehouse")
public class DimensionArchiveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dim_archive_id")
    private Long dimArchiveId;

    @NotNull
    @Column(name = "archive_id")
    private Long archiveId;

    @NotNull
    private String name;

    @NotNull
    private Date validFrom;

    @NotNull
    private Date validTo;
}
