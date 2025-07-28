package dangelodavide.U2_W2_D4_Friday.repository;

import dangelodavide.U2_W2_D4_Friday.entities.Dipendente;
import dangelodavide.U2_W2_D4_Friday.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {
    boolean existsByDipendenteAndDataPrenotazione(Dipendente dipendente, LocalDate dataPrenotazione);
}
