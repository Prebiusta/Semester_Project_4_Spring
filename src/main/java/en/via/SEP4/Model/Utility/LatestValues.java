package en.via.SEP4.Model.Utility;

import en.via.SEP4.Model.DBModel.ArchiveEntity;
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
