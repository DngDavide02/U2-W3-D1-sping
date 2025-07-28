package dangelodavide.U2_W2_D4_Friday.repository;

import dangelodavide.U2_W2_D4_Friday.entities.Dipendente;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, UUID> {
    boolean existsByUsername(String username);
    Optional<Dipendente> findByEmail(String email);
}