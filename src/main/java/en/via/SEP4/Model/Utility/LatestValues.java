package en.via.SEP4.Model.Utility;

import en.via.SEP4.Model.DBModel.ArchiveEntity;
import en.via.SEP4.Model.DBModel.MeasurementEntity;
import en.via.SEP4.Model.DBModel.TemperatureEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class LatestValues {
    private ArchiveEntity archive;
    private float temperature;
    private float carbonDioxide;
    private float humidity;
}
