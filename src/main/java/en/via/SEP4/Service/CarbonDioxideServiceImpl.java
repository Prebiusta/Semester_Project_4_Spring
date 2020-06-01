package en.via.SEP4.Service;

import en.via.SEP4.DAO.DatabaseDAO.ArchiveDao;
import en.via.SEP4.DAO.DatabaseDAO.CarbonDioxideDao;
import en.via.SEP4.DAO.DatabaseDAO.SensorDao;
import en.via.SEP4.DAO.WarehouseDAO.FactCarbonDioxideDao;
import en.via.SEP4.Model.DBModel.CarbonDioxideEntity;
import en.via.SEP4.Model.DWModel.FactCarbonDioxideEntity;
import en.via.SEP4.Model.Utility.StatisticsValues;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CarbonDioxideServiceImpl implements CarbonDioxideService {
    private final CarbonDioxideDao carbonDioxideDao;
    private final FactCarbonDioxideDao factCarbonDioxideDao;


    @Autowired
    public CarbonDioxideServiceImpl(CarbonDioxideDao carbonDioxideDao, FactCarbonDioxideDao factCarbonDioxideDao) {
        this.carbonDioxideDao = carbonDioxideDao;
        this.factCarbonDioxideDao = factCarbonDioxideDao;
    }

    @Override
    public List<CarbonDioxideEntity> getAllCarbonDioxideMeasurementsFromArchiveId(Long archiveId) {
        return carbonDioxideDao.findBySensorEntityArchiveEntity_Id(archiveId);
    }

    @Override
    public List<StatisticsValues> getCarbonDioxideMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate){
        List<FactCarbonDioxideEntity> facts = factCarbonDioxideDao.findAllByArchiveArchiveIdAndDate_RepresentedDateBetween(archiveId,startDate,endDate);

        List<StatisticsValues> statistics = new ArrayList<>();

        if (facts.size() == 0){
            throw new ResourceNotFoundException("No values found in interval " + startDate + " and " + endDate + " for archiveId " + archiveId);
        }

        for (int i = 0 ; i < facts.size();i++)
        {
            Date date = new Date(facts.get(i).getDate().getRepresentedDate().getTime() + (facts.get(i).getTime().getMinutesSinceMidnight() * 60000));
            statistics.add(new StatisticsValues(facts.get(i).getCarbonDioxide(),date));
        }

        return statistics;
    }

    @Override
    public float getAverageCarbonDioxideMeasurementForArchiveByDateInterval(Long archiveId, Date startDate, Date endDate) {
        List<FactCarbonDioxideEntity> facts = factCarbonDioxideDao.findAllByArchiveArchiveIdAndDate_RepresentedDateBetween(archiveId,startDate,endDate);

        if (facts.size() == 0){
            throw new ResourceNotFoundException("No values found in interval " + startDate + " and " + endDate + " for archiveId " + archiveId);
        }

        float sum = 0;
        for (int i = 0 ; i < facts.size();i++)
        {
            sum += facts.get(i).getCarbonDioxide();
        }
        return sum/facts.size();
    }
}
