package en.via.SEP4.Service;

import en.via.SEP4.Model.Utility.LatestValues;

import java.util.List;

public interface LatestValuesService {
    LatestValues getTheLatestMeasurementValues(long archiveId);
    List<LatestValues> getTheLatestMeasurementsForAllArchives();
}
