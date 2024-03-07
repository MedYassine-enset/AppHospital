package ma.yassine.hospital.web;

import ma.yassine.hospital.entities.Patient;
import ma.yassine.hospital.repositiories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping ("/patients")
    public List<Patient> patientList(){
        return patientRepository.findAll();

    }
}
