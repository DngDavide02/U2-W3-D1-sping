package dangelodavide.U2_W2_D4_Friday.repository;

import dangelodavide.U2_W2_D4_Friday.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ViaggioRepository extends JpaRepository<Viaggio, UUID> {}
