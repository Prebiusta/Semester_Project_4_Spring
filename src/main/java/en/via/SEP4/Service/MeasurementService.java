package en.via.SEP4.Service;

import en.via.SEP4.DAO.MeasurementDao;
import en.via.SEP4.Model.Measurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {
    private final MeasurementDao measurementDao;

    public MeasurementService(MeasurementDao measurementDao) {
        this.measurementDao = measurementDao;
    }

    public List<Measurement> getAllMeasurements(){
        return this.measurementDao.findAll();
    }

    public Measurement addMeasurement(Measurement measurement){
        return this.measurementDao.save(measurement);
    }
}
