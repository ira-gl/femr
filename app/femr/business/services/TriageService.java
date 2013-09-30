package femr.business.services;

import com.google.inject.Inject;
import femr.business.dtos.ServiceResponse;
import femr.common.models.IPatient;
import femr.common.models.IPatientEncounter;
import femr.common.models.IPatientEncounterVital;
import femr.data.daos.IRepository;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TriageService implements ITriageService {

    private IRepository<IPatient> patientRepository;
    private IRepository<IPatientEncounter> patientEncounterRepository;
    private IRepository<IPatientEncounterVital> patientEncounterVitalRepository;

    @Inject
    public TriageService(IRepository<IPatient> patientRepository,
                         IRepository<IPatientEncounter> patientEncounterRepository,
                         IRepository<IPatientEncounterVital> patientEncounterVitaRepository){
        this.patientRepository = patientRepository;
        this.patientEncounterRepository = patientEncounterRepository;
        this.patientEncounterVitalRepository = patientEncounterVitaRepository;
    }

    @Override
    public ServiceResponse<IPatient> createPatient(IPatient patient) {
        IPatient newPatient = patientRepository.create(patient);
        ServiceResponse<IPatient> response = new ServiceResponse<>();

        if (newPatient != null){
            response.setResponseObject(newPatient);
        }
        else{
            response.setSuccessful(false);
        }

        return response;
    }

    @Override
    public ServiceResponse<IPatient> getPatient(String id){
        IPatient savedPatient = patientRepository.findOne();//needs to findone
        ServiceResponse<IPatient> response = new ServiceResponse<>();
        response.setResponseObject(savedPatient);
        return response;
    }

    @Override
    public ServiceResponse<IPatientEncounter> createPatientEncounter(IPatientEncounter patientEncounter) {
        IPatientEncounter newPatientEncounter = patientEncounterRepository.create(patientEncounter);
        ServiceResponse<IPatientEncounter> response = new ServiceResponse<>();

        if (newPatientEncounter != null){
            response.setResponseObject(newPatientEncounter);
        }
        else{
            response.setSuccessful(false);
        }
        return response;
    }

    @Override
    public ServiceResponse<IPatientEncounterVital> createPatientEncounterVital(IPatientEncounterVital patientEncounterVital){
        IPatientEncounterVital newPatientEncounterVital = patientEncounterVitalRepository.create(patientEncounterVital);
        ServiceResponse<IPatientEncounterVital> response = new ServiceResponse<>();

        if (newPatientEncounterVital != null){
            response.setResponseObject(newPatientEncounterVital);
        }
        else{
            response.setSuccessful(false);
        }
        return response;
    }

    @Override
    public String getCurrentDateTime(){
        Date dt = new Date();
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateTimeFormat.format(dt);
        return currentTime;
    }
}
