package en.via.SEP4.Service;

import en.via.SEP4.Model.Utility.LatestValues;

public interface LatestValuesService {
    LatestValues getTheLatestMeasurementValues(Long archiveId);
}
