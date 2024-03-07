package ma.yassine.hospital.repositiories;

import ma.yassine.hospital.entities.Medecin;
import ma.yassine.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecienRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
