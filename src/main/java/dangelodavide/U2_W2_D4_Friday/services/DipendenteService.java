package dangelodavide.U2_W2_D4_Friday.services;

import dangelodavide.U2_W2_D4_Friday.entities.Dipendente;
import dangelodavide.U2_W2_D4_Friday.exceptions.BadRequestException;
import dangelodavide.U2_W2_D4_Friday.exceptions.ResourceNotFoundException;
import dangelodavide.U2_W2_D4_Friday.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class DipendenteService {
    @Autowired
    private final DipendenteRepository repository;

    public DipendenteService(DipendenteRepository repository){
        this.repository = repository;
    }

    public List<Dipendente> findAll(){
        return repository.findAll();
    }

    public Dipendente save(Dipendente dipendente) {
        try {
            return repository.save(dipendente);
        } catch (DataIntegrityViolationException e) {
            throw new BadRequestException("Violazione vincolo dati: probabilmente username o email già esistenti.");
        } catch (Exception e) {
            throw new BadRequestException("Errore durante il salvataggio del dipendente.");
        }
    }

    public Dipendente findById(UUID id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dipendente con ID " + id + " non trovato."));
    }

    public void deleteById(UUID id){
        repository.deleteById(id);
    }

    public Dipendente findByEmail(String email) {
        return this.repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Dipendente con email " + email + " non trovato."));
    }


}
