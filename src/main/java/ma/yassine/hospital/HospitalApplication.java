package ma.yassine.hospital;

import ma.yassine.hospital.entities.*;
import ma.yassine.hospital.repositiories.ConsultationRepository;
import ma.yassine.hospital.repositiories.MedecienRepository;
import ma.yassine.hospital.repositiories.PatientRepository;
import ma.yassine.hospital.repositiories.RendezVousRepository;
import ma.yassine.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	@Bean
	CommandLineRunner start(IHospitalService iHospitalService,
							PatientRepository patientRepository,
							RendezVousRepository rendezVousRepository,
							MedecienRepository medecienRepository){
		return args -> {
			Stream.of("Mohamed","Hassan","Latifa").forEach(
					name->{
						Patient patient=new Patient();
						patient.setNom(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						iHospitalService.savePatient(patient);
					});
					Stream.of("Aymene","Tourya","Yassmine").forEach(
							name->{
								Medecin medecin=new Medecin();
								medecin.setNom(name);
								medecin.setEmail(name+"Gmail.com");
								medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
								iHospitalService.saveMedecin(medecin);
							});
					Patient patient=patientRepository.findAll().get(0);
					Patient patient1=patientRepository.findByNom("Mohamed");

					Medecin medecin=medecienRepository.findByNom("Yassmine");

			        RendezVous rendezVous=new RendezVous();
					rendezVous.setDate(new Date());
					rendezVous.setStatus(StatusRDV.PENDING);
					rendezVous.setMedecin(medecin);
					rendezVous.setPatient(patient);
			RendezVous SAVERendezVous = iHospitalService.saveRDV(rendezVous);
			System.out.println(SAVERendezVous.getId());

			RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
					Consultation consultation=new Consultation();
					consultation.setDateConsultation(new Date());
					consultation.setRendezVous(rendezVous1);
					consultation.setRapport("Rapport de la consultation");
					iHospitalService.saveConsultation(consultation);


		};
	}

}
