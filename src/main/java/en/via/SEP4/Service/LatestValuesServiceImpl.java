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
    private final ArchiveDao archiveDao;



    @Autowired
    public LatestValuesServiceImpl(CarbonDioxideDao carbonDioxideDao, HumidityDao humidityDao, TemperatureDao temperatureDao, ArchiveDao archiveDao) {
        this.carbonDioxideDao = carbonDioxideDao;
        this.humidityDao = humidityDao;
        this.temperatureDao = temperatureDao;

        this.archiveDao = archiveDao;
    }

    @Override
    public LatestValues getTheLatestMeasurementValues(ArchiveEntity archiveId) {
        CarbonDioxideEntity latestCarbonDioxide = carbonDioxideDao.findFirstByArchiveEntityIdOrderByIdDesc(archiveId.getId());
        HumidityEntity latestHumidity = humidityDao.findFirstByArchiveEntityIdOrderByIdDesc(archiveId.getId());
        TemperatureEntity latestTemperature = temperatureDao.findFirstByArchiveEntityIdOrderByIdDesc(archiveId.getId());

        return new LatestValues(archiveId, latestTemperature, latestCarbonDioxide, latestHumidity);
    }

    @Override
     public List<LatestValues> getTheLatestMeasurementsForAllArchives()
    {
        List<LatestValues> latestValuesForAllArchives = new ArrayList<>();
        List<ArchiveEntity> allArchives = new ArrayList<>();


        ArchiveEntity archiveId;
        allArchives = archiveDao.findAll();
        for (ArchiveEntity allArchive : allArchives) {
            archiveId = allArchive;
            latestValuesForAllArchives.add(getTheLatestMeasurementValues(archiveId));
        }
        return latestValuesForAllArchives;
    }



}
