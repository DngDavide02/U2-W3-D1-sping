package dangelodavide.U2_W2_D4_Friday.Payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record DipendentePayload(UUID id, @NotBlank String username, @NotBlank String nome, @NotBlank String cognome, @Email @NotBlank String email, String immagineProfiloPath) {}
