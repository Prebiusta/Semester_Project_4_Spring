package en.via.SEP4.Service;

import en.via.SEP4.DAO.DatabaseDAO.ArchiveDao;
import en.via.SEP4.DAO.DatabaseDAO.TemperatureDao;
import en.via.SEP4.DAO.WarehouseDAO.FactCarbonDioxideDao;
import en.via.SEP4.DAO.WarehouseDAO.FactTemperatureDao;
import en.via.SEP4.Model.DBModel.TemperatureEntity;
import en.via.SEP4.Model.DWModel.FactHumidityEntity;
import en.via.SEP4.Model.DWModel.FactTemperatureEntity;
import en.via.SEP4.Model.Utility.StatisticsValues;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TemperatureServiceImpl implements TemperatureService {
    private final TemperatureDao temperatureDao;
    private final ArchiveDao archiveDao;
    private final FactTemperatureDao factTemperatureDao;



    @Autowired
    public TemperatureServiceImpl(TemperatureDao temperatureDao, ArchiveDao archiveDao,FactTemperatureDao factTemperatureDao) {
        this.temperatureDao = temperatureDao;
        this.archiveDao = archiveDao;
        this.factTemperatureDao = factTemperatureDao;
    }

    @Override
    public TemperatureEntity addTemperatureMeasurementToArchive(Long archiveId, TemperatureEntity temperatureMeasurement) {
        return archiveDao.findById(archiveId).map(archive -> {
            temperatureMeasurement.setArchiveEntity(archive);
            return temperatureDao.save(temperatureMeasurement);
        }).orElseThrow(() -> new ResourceNotFoundException("ArchiveId " + archiveId + " not found"));
    }

    @Override
    public List<TemperatureEntity> getAllTemperatureMeasurementsFromArchiveId(Long archiveId) {
        return temperatureDao.findByArchiveEntityId(archiveId);
    }

    @Override
    public List<StatisticsValues> getTemperatureMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate) {
        List<FactTemperatureEntity> facts = factTemperatureDao.findAllByArchiveArchiveIdAndDate_RepresentedDateBetween(archiveId,startDate,endDate);

        List<StatisticsValues> temperatureStatistics = new ArrayList<StatisticsValues>();
        for (int i = 0 ; i < facts.size();i++)
        {
            facts.get(i).getDate().getRepresentedDate().setTime(facts.get(i).getTime().getMinutesSinceMidnight());
            temperatureStatistics.add(new StatisticsValues(facts.get(i).getTemperature(),facts.get(i).getDate().getRepresentedDate()));
        }

        return temperatureStatistics;
    }

    @Override
    public float getAverageTemperatureMeasurementForArchiveByDateInterval(Long archiveId, Date startDate, Date endDate) {
        List<FactTemperatureEntity> temperatureFacts;
        float sum = 0;
        float average =0;
        temperatureFacts = factTemperatureDao.findAllByArchiveArchiveIdAndDate_RepresentedDateBetween(archiveId,startDate,endDate);
        for(int i =0;i<temperatureFacts.size();i++)
        {
            sum += temperatureFacts.get(i).getTemperature();
        }
        average = sum/temperatureFacts.size();

        return average;

    }

}
