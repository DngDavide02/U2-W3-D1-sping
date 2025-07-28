package dangelodavide.U2_W2_D4_Friday.controller;

import dangelodavide.U2_W2_D4_Friday.Payloads.PrenotazionePayload;
import dangelodavide.U2_W2_D4_Friday.entities.Prenotazione;
import dangelodavide.U2_W2_D4_Friday.services.PrenotazioneService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    private final PrenotazioneService service;

    public PrenotazioneController(PrenotazioneService service) {
        this.service = service;
    }

    @GetMapping
    public List<Prenotazione> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Prenotazione getById(@PathVariable UUID id){
        return service.findById(id);
    }

    @PostMapping
    public Prenotazione create(@RequestBody @Validated PrenotazionePayload payload){
        return service.save(payload);
    }

    @PutMapping("/{id}")
    public Prenotazione update(@PathVariable UUID id, @RequestBody @Validated PrenotazionePayload payload) {
        return service.update(id, payload);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        service.deleteById(id);
    }
}
