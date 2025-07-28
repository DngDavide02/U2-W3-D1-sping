package dangelodavide.U2_W2_D4_Friday.Payloads;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record PrenotazionePayload(UUID id, @NotNull UUID viaggioId, @NotNull UUID dipendenteId, @NotNull LocalDate dataPrenotazione, String note) {}
