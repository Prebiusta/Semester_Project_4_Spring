package en.via.SEP4.Service;

import en.via.SEP4.DAO.DatabaseDAO.ArchiveDao;
import en.via.SEP4.DAO.DatabaseDAO.HumidityDao;
import en.via.SEP4.DAO.WarehouseDAO.FactHumidityDao;
import en.via.SEP4.Model.DBModel.HumidityEntity;
import en.via.SEP4.Model.DWModel.FactHumidityEntity;
import en.via.SEP4.Model.Utility.StatisticsValues;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HumidityServiceImpl implements HumidityService {
    private final HumidityDao humidityDao;
    private final ArchiveDao archiveDao;
    private final FactHumidityDao factHumidityDao;

    @Autowired
    public HumidityServiceImpl(HumidityDao humidityDao, ArchiveDao archiveDao, FactHumidityDao factHumidityDao) {
        this.humidityDao = humidityDao;
        this.archiveDao = archiveDao;
        this.factHumidityDao = factHumidityDao;
    }

    @Override
    public HumidityEntity addHumidityMeasurementToArchive(Long archiveId, HumidityEntity humidityMeasurement) {
        return archiveDao.findById(archiveId).map(archive -> {
            humidityMeasurement.setArchiveEntity(archive);
            return humidityDao.save(humidityMeasurement);
        }).orElseThrow(() -> new ResourceNotFoundException("ArchiveId " + archiveId + " not found"));
    }

    @Override
    public List<HumidityEntity> getAllHumidityMeasurementsFromArchiveId(Long archiveId) {
        return humidityDao.findByArchiveEntityId(archiveId);
    }

    @Override
    public List<StatisticsValues> getHumidityMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate) {
        List<FactHumidityEntity> facts = factHumidityDao.findAllByArchiveArchiveIdAndDate_RepresentedDateBetween(archiveId,startDate,endDate);

        List<StatisticsValues> humidityStatistics = new ArrayList<StatisticsValues>();
        for (int i = 0 ; i < facts.size();i++)
        {
            facts.get(i).getDate().getRepresentedDate().setTime(facts.get(i).getTime().getMinutesSinceMidnight());
            humidityStatistics.add(new StatisticsValues(facts.get(i).getHumidity(),facts.get(i).getDate().getRepresentedDate()));
        }

        return humidityStatistics;
    }

    @Override
    public float getAverageHumidityMeasurementForArchiveByDateInterval(Long archiveId, Date startDate, Date endDate) {
        List<FactHumidityEntity> facts = factHumidityDao.findAllByArchiveArchiveIdAndDate_RepresentedDateBetween(archiveId,startDate,endDate);
        float sum = 0;
        for (int i = 0 ; i < facts.size();i++)
        {
            sum = facts.get(i).getHumidity();
        }
        return sum/facts.size();
    }
}
