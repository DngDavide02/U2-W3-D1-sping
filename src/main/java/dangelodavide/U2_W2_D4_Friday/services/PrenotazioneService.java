package dangelodavide.U2_W2_D4_Friday.services;

import dangelodavide.U2_W2_D4_Friday.Payloads.PrenotazionePayload;
import dangelodavide.U2_W2_D4_Friday.entities.Dipendente;
import dangelodavide.U2_W2_D4_Friday.entities.Prenotazione;
import dangelodavide.U2_W2_D4_Friday.entities.Viaggio;
import dangelodavide.U2_W2_D4_Friday.exceptions.BadRequestException;
import dangelodavide.U2_W2_D4_Friday.exceptions.ResourceNotFoundException;
import dangelodavide.U2_W2_D4_Friday.repository.PrenotazioneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PrenotazioneService {
    private final PrenotazioneRepository repository;
    private final ViaggioService viaggioService;
    private final DipendenteService dipendenteService;

    public PrenotazioneService(PrenotazioneRepository repository, ViaggioService viaggioService, DipendenteService dipendenteService) {
        this.repository = repository;
        this.viaggioService = viaggioService;
        this.dipendenteService = dipendenteService;
    }

    //---------------------find all-----------------------------------
    public List<Prenotazione> findAll(){
        return repository.findAll();
    }//fine find all

    //----------------------------------find by id--------------------------------------
    public Prenotazione findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Prenotazione non trovata con id: " + id));
    }//fine find by id

    //------------------save---------------------------------
    public Prenotazione save(PrenotazionePayload payload) {
        Viaggio viaggio = viaggioService.findById(payload.viaggioId());
        Dipendente dipendente = dipendenteService.findById(payload.dipendenteId());

        boolean exists = repository.existsByDipendenteAndDataPrenotazione(dipendente, payload.dataPrenotazione());
        if (exists) {
            throw new BadRequestException("Il dipendente ha già una prenotazione per questa data");
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setViaggio(viaggio);
        prenotazione.setDipendente(dipendente);
        prenotazione.setDataPrenotazione(payload.dataPrenotazione());
        prenotazione.setNote(payload.note());

        return repository.save(prenotazione);
    }//fine save

    //----------------------------update----------------------------------
    public Prenotazione update(UUID id, PrenotazionePayload payload) {
        Prenotazione p = this.findById(id);

        Viaggio viaggio = viaggioService.findById(payload.viaggioId());
        Dipendente dipendente = dipendenteService.findById(payload.dipendenteId());

        p.setViaggio(viaggio);
        p.setDipendente(dipendente);
        p.setDataPrenotazione(payload.dataPrenotazione());
        p.setNote(payload.note());

        return repository.save(p);
    }//fine update

    //--------------------------------------delete---------------------------------------
    public void deleteById(UUID id){
        repository.deleteById(id);
    }//fine delete
}
