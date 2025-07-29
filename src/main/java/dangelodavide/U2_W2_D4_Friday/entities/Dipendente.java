package dangelodavide.U2_W2_D4_Friday.entities;

import dangelodavide.U2_W2_D4_Friday.Payloads.DipendentePayload;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(unique = true)
    private String username;

    @NotBlank
    private String nome;

    @NotBlank
    private String cognome;

    @Email
    @NotBlank
    private String email;

    private String password;


    private String immagineProfiloPath;

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImmagineProfiloPath() {
        return immagineProfiloPath;
    }

    public void setImmagineProfiloPath(String immagineProfiloPath) {
        this.immagineProfiloPath = immagineProfiloPath;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Dipendente fromPayload(DipendentePayload payload) {
        Dipendente dipendente = new Dipendente();
        dipendente.setUsername(payload.username());
        dipendente.setNome(payload.nome());
        dipendente.setCognome(payload.cognome());
        dipendente.setEmail(payload.email());
        dipendente.setPassword(payload.password());
        dipendente.setImmagineProfiloPath(payload.immagineProfiloPath());
        return dipendente;
    }

}
