package en.via.SEP4.Model.DBModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"date"},
        allowGetters =  true
)
public abstract class MeasurementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private float value;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false, updatable = false)
    @CreatedDate
    private Date date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "archive_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ArchiveEntity archiveEntity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sensor_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SensorEntity sensorEntity;
}
