package dangelodavide.U2_W2_D4_Friday.Payloads;

import java.time.LocalDateTime;
import java.util.List;

public record ErroreDettagliato(String message, LocalDateTime timestamp, List<String> details) {
}
