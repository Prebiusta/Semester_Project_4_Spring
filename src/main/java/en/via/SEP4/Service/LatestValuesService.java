package en.via.SEP4.Service;

import en.via.SEP4.Model.DBModel.ArchiveEntity;
import en.via.SEP4.Model.Utility.LatestValues;

public interface LatestValuesService {
    LatestValues getTheLatestMeasurementValues(ArchiveEntity archiveId);
}
