package ma.yassine.hospital.service;

import jakarta.transaction.Transactional;
import ma.yassine.hospital.entities.Consultation;
import ma.yassine.hospital.entities.Medecin;
import ma.yassine.hospital.entities.Patient;
import ma.yassine.hospital.entities.RendezVous;
import ma.yassine.hospital.repositiories.ConsultationRepository;
import ma.yassine.hospital.repositiories.MedecienRepository;
import ma.yassine.hospital.repositiories.PatientRepository;
import ma.yassine.hospital.repositiories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {

    private PatientRepository patientRepository;
    private MedecienRepository medecienRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecienRepository medecienRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecienRepository = medecienRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecienRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
