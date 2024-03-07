package ma.yassine.hospital.service;

import ma.yassine.hospital.entities.Consultation;
import ma.yassine.hospital.entities.Medecin;
import ma.yassine.hospital.entities.Patient;
import ma.yassine.hospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);

    Consultation saveConsultation(Consultation consultation);
}
