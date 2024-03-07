package ma.yassine.hospital.repositiories;

import ma.yassine.hospital.entities.Consultation;
import ma.yassine.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
