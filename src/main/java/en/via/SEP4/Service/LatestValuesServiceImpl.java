package en.via.SEP4.Service;

import en.via.SEP4.DAO.DatabaseDAO.ArchiveDao;
import en.via.SEP4.DAO.DatabaseDAO.CarbonDioxideDao;
import en.via.SEP4.DAO.DatabaseDAO.HumidityDao;
import en.via.SEP4.DAO.DatabaseDAO.TemperatureDao;
import en.via.SEP4.Model.DBModel.ArchiveEntity;
import en.via.SEP4.Model.DBModel.CarbonDioxideEntity;
import en.via.SEP4.Model.DBModel.HumidityEntity;
import en.via.SEP4.Model.DBModel.TemperatureEntity;
import en.via.SEP4.Model.Utility.LatestValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LatestValuesServiceImpl implements LatestValuesService {
    private final CarbonDioxideDao carbonDioxideDao;
    private final HumidityDao humidityDao;
    private final TemperatureDao temperatureDao;
    private final ArchiveDao archiveDao;

    @Autowired
    public LatestValuesServiceImpl(CarbonDioxideDao carbonDioxideDao, HumidityDao humidityDao, TemperatureDao temperatureDao, ArchiveDao archiveDao) {
        this.carbonDioxideDao = carbonDioxideDao;
        this.humidityDao = humidityDao;
        this.temperatureDao = temperatureDao;
        this.archiveDao = archiveDao;
    }

    @Override
    public LatestValues getTheLatestMeasurementValues(long archiveId) {
        CarbonDioxideEntity latestCarbonDioxide = carbonDioxideDao.findFirstBySensorEntityArchiveEntityIdOrderByIdDesc(archiveId);
        HumidityEntity latestHumidity = humidityDao.findFirstBySensorEntityArchiveEntityIdOrderByIdDesc(archiveId);
        TemperatureEntity latestTemperature = temperatureDao.findFirstBySensorEntityArchiveEntityIdOrderByIdDesc(archiveId);

        return new LatestValues(archiveDao.findById(archiveId).get(), latestTemperature.getValue(), latestCarbonDioxide.getValue(), latestHumidity.getValue());
    }

    @Override
    public List<LatestValues> getTheLatestMeasurementsForAllArchives() {
        List<LatestValues> latestValuesForAllArchives = new ArrayList<>();
        List<ArchiveEntity> allArchives;
        allArchives = archiveDao.findAll();

        for (ArchiveEntity archiveEntity : allArchives) {
            latestValuesForAllArchives.add(getTheLatestMeasurementValues(archiveEntity.getId()));
        }

        return latestValuesForAllArchives;
    }
}
