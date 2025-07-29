package dangelodavide.U2_W2_D4_Friday.services;

import dangelodavide.U2_W2_D4_Friday.entities.Dipendente;
import dangelodavide.U2_W2_D4_Friday.exceptions.BadRequestException;
import dangelodavide.U2_W2_D4_Friday.exceptions.ResourceNotFoundException;
import dangelodavide.U2_W2_D4_Friday.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Dipendente save(Dipendente payload) {
        repository.findByEmail(payload.getEmail()).ifPresent(d -> {
            throw new BadRequestException("L'email " + d.getEmail() + " è già in uso!");
        });

        Dipendente dip = new Dipendente();
        dip.setNome(payload.getNome());
        dip.setCognome(payload.getCognome());
        dip.setEmail(payload.getEmail());
        dip.setUsername(payload.getUsername());
        dip.setPassword(payload.getPassword());

        return repository.save(dip);
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
