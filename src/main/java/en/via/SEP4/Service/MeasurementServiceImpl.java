package en.via.SEP4.Service;

import en.via.SEP4.DAO.DatabaseDAO.CarbonDioxideDao;
import en.via.SEP4.DAO.DatabaseDAO.HumidityDao;
import en.via.SEP4.DAO.DatabaseDAO.SensorDao;
import en.via.SEP4.DAO.DatabaseDAO.TemperatureDao;
import en.via.SEP4.Model.DBModel.CarbonDioxideEntity;
import en.via.SEP4.Model.DBModel.HumidityEntity;
import en.via.SEP4.Model.DBModel.TemperatureEntity;
import en.via.SEP4.Model.Utility.MeasurementValues;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasurementServiceImpl implements MeasurementService {
    private final CarbonDioxideDao carbonDioxideDao;
    private final HumidityDao humidityDao;
    private final TemperatureDao temperatureDao;
    private final SensorDao sensorDao;

    @Autowired
    public MeasurementServiceImpl(CarbonDioxideDao carbonDioxideDao, HumidityDao humidityDao, TemperatureDao temperatureDao, SensorDao sensorDao) {
        this.carbonDioxideDao = carbonDioxideDao;
        this.humidityDao = humidityDao;
        this.temperatureDao = temperatureDao;
        this.sensorDao = sensorDao;
    }

    @Override
    public boolean saveNewMeasurement(MeasurementValues measurementValues) {
        addCarbonDioxideValue(measurementValues.getCarbonDioxideValue(), measurementValues.getCarbonDioxideSensorId());
        addHumidityValue(measurementValues.getHumidityValue(), measurementValues.getHumiditySensorId());
        addTemperatureValue(measurementValues.getTemperatureValue(), measurementValues.getTemperatureSensorId());

        return true;
    }

    private void addCarbonDioxideValue(float carbonDioxideValue, Long measurementId){
        sensorDao.findById(measurementId).map(sensorEntity -> {
            CarbonDioxideEntity carbonDioxideEntity = new CarbonDioxideEntity();
            carbonDioxideEntity.setValue(carbonDioxideValue);
            carbonDioxideEntity.setSensorEntity(sensorEntity);
            carbonDioxideDao.save(carbonDioxideEntity);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException("SensorID " + measurementId + " not found"));
    }

    private void addHumidityValue(float humidityValue, Long measurementId){
        sensorDao.findById(measurementId).map(sensorEntity -> {
            HumidityEntity humidityEntity = new HumidityEntity();
            humidityEntity.setValue(humidityValue);
            humidityEntity.setSensorEntity(sensorEntity);
            humidityDao.save(humidityEntity);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException("SensorID " + measurementId + " not found"));
    }

    private void addTemperatureValue(float temperatureValue, Long measurementId){
        sensorDao.findById(measurementId).map(sensorEntity -> {
            TemperatureEntity temperatureEntity = new TemperatureEntity();
            temperatureEntity.setValue(temperatureValue);
            temperatureEntity.setSensorEntity(sensorEntity);
            temperatureDao.save(temperatureEntity);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException("SensorID " + measurementId + " not found"));
    }
}
