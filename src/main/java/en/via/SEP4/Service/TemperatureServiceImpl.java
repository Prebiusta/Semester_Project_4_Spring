package en.via.SEP4.Service;

import en.via.SEP4.DAO.DatabaseDAO.ArchiveDao;
import en.via.SEP4.DAO.DatabaseDAO.TemperatureDao;
import en.via.SEP4.DAO.WarehouseDAO.FactTemperatureDao;
import en.via.SEP4.Model.DBModel.TemperatureEntity;
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
            return null;
//        return archiveDao.findById(archiveId).map(archive -> {
//            temperatureMeasurement.setArchiveEntity(archive);
//            return temperatureDao.save(temperatureMeasurement);
//        }).orElseThrow(() -> new ResourceNotFoundException("ArchiveId " + archiveId + " not found"));
    }

    @Override
    public List<TemperatureEntity> getAllTemperatureMeasurementsFromArchiveId(Long archiveId) {
        return temperatureDao.findBySensorEntityArchiveEntity_Id(archiveId);
    }

    @Override
    public List<StatisticsValues> getTemperatureMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate) {
        List<FactTemperatureEntity> facts = factTemperatureDao.findAllByArchiveArchiveIdAndDate_RepresentedDateBetween(archiveId,startDate,endDate);

        if (facts.size() == 0){
            throw new ResourceNotFoundException("No values found in interval " + startDate + " and " + endDate + " for archiveId " + archiveId);
        }

        List<StatisticsValues> temperatureStatistics = new ArrayList<StatisticsValues>();
        Date date;
        for (int i = 0 ; i < facts.size();i++)
        {
            date = new Date(facts.get(i).getDate().getRepresentedDate().getTime() + (facts.get(i).getTime().getMinutesSinceMidnight() * 60000));
            temperatureStatistics.add(new StatisticsValues(facts.get(i).getTemperature(),date));
        }

        return temperatureStatistics;
    }

    @Override
    public float getAverageTemperatureMeasurementForArchiveByDateInterval(Long archiveId, Date startDate, Date endDate) {
        List<FactTemperatureEntity> temperatureFacts = factTemperatureDao.findAllByArchiveArchiveIdAndDate_RepresentedDateBetween(archiveId,startDate,endDate);

        if (temperatureFacts.size() == 0){
            throw new ResourceNotFoundException("No values found in interval " + startDate + " and " + endDate + " for archiveId " + archiveId);
        }

        float sum = 0;
        float average =0;
        for(int i =0;i<temperatureFacts.size();i++)
        {
            sum += temperatureFacts.get(i).getTemperature();
        }
        average = sum/temperatureFacts.size();

        return average;
    }

}
