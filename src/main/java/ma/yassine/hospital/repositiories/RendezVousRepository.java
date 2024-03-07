package ma.yassine.hospital.repositiories;

import ma.yassine.hospital.entities.Patient;
import ma.yassine.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
}
