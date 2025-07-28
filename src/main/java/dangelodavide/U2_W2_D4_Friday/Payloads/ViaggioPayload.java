package dangelodavide.U2_W2_D4_Friday.Payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record ViaggioPayload(UUID id, @NotBlank String destinazione, @NotNull LocalDate data, String stato) {}
