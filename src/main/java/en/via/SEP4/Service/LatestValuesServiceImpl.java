package en.via.SEP4.Service;

import en.via.SEP4.DAO.ArchiveDao;
import en.via.SEP4.DAO.CarbonDioxideDao;
import en.via.SEP4.DAO.HumidityDao;
import en.via.SEP4.DAO.TemperatureDao;
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


    @Autowired
    public LatestValuesServiceImpl(CarbonDioxideDao carbonDioxideDao, HumidityDao humidityDao, TemperatureDao temperatureDao) {
        this.carbonDioxideDao = carbonDioxideDao;
        this.humidityDao = humidityDao;
        this.temperatureDao = temperatureDao;

    }

    @Override
    public LatestValues getTheLatestMeasurementValues(ArchiveEntity archiveId) {
        CarbonDioxideEntity latestCarbonDioxide = carbonDioxideDao.findFirstByArchiveEntityIdOrderByIdDesc(archiveId.getId());
        HumidityEntity latestHumidity = humidityDao.findFirstByArchiveEntityIdOrderByIdDesc(archiveId.getId());
        TemperatureEntity latestTemperature = temperatureDao.findFirstByArchiveEntityIdOrderByIdDesc(archiveId.getId());

        return new LatestValues(archiveId, latestTemperature.getValue(), latestCarbonDioxide.getValue(), latestHumidity.getValue());
    }


}
