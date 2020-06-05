package en.via.SEP4.Service;

import en.via.SEP4.DAO.DatabaseDAO.CarbonDioxideDao;
import en.via.SEP4.DAO.WarehouseDAO.FactCarbonDioxideDao;
import en.via.SEP4.Model.DBModel.ArchiveEntity;
import en.via.SEP4.Model.DBModel.CarbonDioxideEntity;
import en.via.SEP4.Model.DBModel.OptimalValuesEntity;
import en.via.SEP4.Model.DBModel.SensorEntity;
import en.via.SEP4.Model.DWModel.DimensionArchiveEntity;
import en.via.SEP4.Model.DWModel.DimensionDateEntity;
import en.via.SEP4.Model.DWModel.DimensionTimeOfDayEntity;
import en.via.SEP4.Model.DWModel.FactCarbonDioxideEntity;
import en.via.SEP4.Model.Utility.StatisticsValues;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CarbonDioxideServiceImplTest {

    @Mock
    private CarbonDioxideDao carbonDioxideDao;

    @Mock
    private FactCarbonDioxideDao factCarbonDioxideDao;

    @InjectMocks
    private CarbonDioxideServiceImpl service;
    CarbonDioxideServiceImplTest() throws ParseException {
    }

    @BeforeAll
    public void setup(){
        MockitoAnnotations.initMocks(this);
        List<CarbonDioxideEntity> dummyCo2Entities = new ArrayList<>();

        long id = 1;
        OptimalValuesEntity optimalValuesEntity = new OptimalValuesEntity();
        optimalValuesEntity.setId(id);
        optimalValuesEntity.setOptimalCarbonDioxide(300);
        optimalValuesEntity.setOptimalHumidity(60);
        optimalValuesEntity.setOptimalTemperature(22);

        ArchiveEntity archiveEntity = new ArchiveEntity();
        archiveEntity.setId(id);
        archiveEntity.setName("Test" + id);
        archiveEntity.setOptimalValuesEntity(optimalValuesEntity);

        SensorEntity sensorEntity = new SensorEntity();
        sensorEntity.setId(id);
        sensorEntity.setArchiveEntity(archiveEntity);

        for (int i = 0; i < 50; i ++){
            long currentId = i + 1;
            CarbonDioxideEntity entity = new CarbonDioxideEntity();
            entity.setSensorEntity(sensorEntity);
            entity.setDate(new Date());
            entity.setId(currentId);
            entity.setValue(300);

            dummyCo2Entities.add(entity);
        }

        List<FactCarbonDioxideEntity> dummyFactCo2Entities = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            FactCarbonDioxideEntity factCarbonDioxideEntity = mock(FactCarbonDioxideEntity.class);
            factCarbonDioxideEntity.setCarbonDioxide(240);
            dummyFactCo2Entities.add(factCarbonDioxideEntity);
            when(factCarbonDioxideEntity.getCarbonDioxide()).thenReturn(240f);

            DimensionDateEntity dimensionDateEntity = mock(DimensionDateEntity.class);
            when(dimensionDateEntity.getRepresentedDate()).thenReturn(new Date());

            when(factCarbonDioxideEntity.getDate()).thenReturn(dimensionDateEntity);

            DimensionTimeOfDayEntity dimensionTimeOfDayEntity = mock(DimensionTimeOfDayEntity.class);
            when(dimensionTimeOfDayEntity.getMinutesSinceMidnight()).thenReturn(200);

            when(factCarbonDioxideEntity.getTime()).thenReturn(dimensionTimeOfDayEntity);
        }

        when(carbonDioxideDao.findBySensorEntityArchiveEntityId(TESTED_ARCHIVE_ID))
                .thenReturn(dummyCo2Entities);
        when(factCarbonDioxideDao.findAllByArchiveArchiveIdAndDate_RepresentedDateBetween(TESTED_ARCHIVE_ID, START_DATE, END_DATE))
                .thenReturn(dummyFactCo2Entities);
        when(factCarbonDioxideDao.findAllByArchiveArchiveIdAndDate_RepresentedDateBetween(TESTED_ARCHIVE_ID, START_DATE, END_DATE))
                .thenReturn(dummyFactCo2Entities);
    }

    private static final long TESTED_ARCHIVE_ID = 1;

    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    private final Date START_DATE = format.parse("2020/01/01");
    private final Date END_DATE = format.parse("2020/12/31");

    @Test
    public void testGetAllCarbonDioxideMeasurementsFromArchiveId(){
        List<CarbonDioxideEntity> allCarbonDioxideMeasurementsFromArchiveId = service.getAllCarbonDioxideMeasurementsFromArchiveId(TESTED_ARCHIVE_ID);
        assertEquals(50, allCarbonDioxideMeasurementsFromArchiveId.size());
    }

    @Test
    public void testGetAllCarbonDioxideMeasurementsFromWrongArchiveId(){
        List<CarbonDioxideEntity> allCarbonDioxideMeasurementsFromArchiveId = service.getAllCarbonDioxideMeasurementsFromArchiveId(TESTED_ARCHIVE_ID + 1);
        assertEquals(0, allCarbonDioxideMeasurementsFromArchiveId.size());
    }

    @Test
    public void testGetAllCarbonDioxideMeasurementsFromNullArchiveId(){
        List<CarbonDioxideEntity> allCarbonDioxideMeasurementsFromArchiveId = service.getAllCarbonDioxideMeasurementsFromArchiveId(null);
        assertEquals(0, allCarbonDioxideMeasurementsFromArchiveId.size());
    }

    @Test
    public void testGetAllCarbonDioxideMeasurementsFromNegativeArchiveId(){
        List<CarbonDioxideEntity> allCarbonDioxideMeasurementsFromArchiveId = service.getAllCarbonDioxideMeasurementsFromArchiveId((long) -1);
        assertEquals(0, allCarbonDioxideMeasurementsFromArchiveId.size());
    }

    @Test
    public void getCarbonDioxideMeasurementsByDateInterval() {
        List<StatisticsValues> allCarbonDioxideMeasurementsForDateInterval = service.getCarbonDioxideMeasurementsByDateInterval(TESTED_ARCHIVE_ID, START_DATE, END_DATE);
        assertEquals(20, allCarbonDioxideMeasurementsForDateInterval.size());
    }

    @Test
    public void getCarbonDioxideMeasurementsByDateIntervalIncorrectArchiveId() {
        assertThrows(ResourceNotFoundException.class, () -> service.getCarbonDioxideMeasurementsByDateInterval((long) -10, START_DATE, END_DATE));
    }

    @Test
    public void getCarbonDioxideMeasurementsByDateIntervalNonExistingArchiveId() {
        assertThrows(ResourceNotFoundException.class, () -> service.getCarbonDioxideMeasurementsByDateInterval((long) 20, START_DATE, END_DATE));
    }

    @Test
    public void getCarbonDioxideMeasurementsByDateIntervalNullArchiveId() {
        assertThrows(ResourceNotFoundException.class, () -> service.getCarbonDioxideMeasurementsByDateInterval(null, START_DATE, END_DATE));
    }

    @Test
    public void testGetAverageCarbonDioxideMeasurementForArchiveByDateInterval() {
        float averageCo2 = service.getAverageCarbonDioxideMeasurementForArchiveByDateInterval(TESTED_ARCHIVE_ID, START_DATE, END_DATE);
        assertEquals(240, averageCo2);
    }

    @Test
    public void testGetAverageCarbonDioxideMeasurementForInvalidArchiveByDateInterval() {
        assertThrows(ResourceNotFoundException.class, () -> service.getCarbonDioxideMeasurementsByDateInterval(null, START_DATE, END_DATE));
    }

    @Test
    public void testGetAverageCarbonDioxideMeasurementForNullArchiveByDateInterval() {
        assertThrows(ResourceNotFoundException.class, () -> service.getAverageCarbonDioxideMeasurementForArchiveByDateInterval(null, START_DATE, END_DATE));
    }

    @Test
    public void testGetAverageCarbonDioxideMeasurementForNonExistingArchiveByDateInterval() {
        assertThrows(ResourceNotFoundException.class, () -> service.getAverageCarbonDioxideMeasurementForArchiveByDateInterval((long) 20, START_DATE, END_DATE));
    }
}