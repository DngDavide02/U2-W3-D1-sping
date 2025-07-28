package dangelodavide.U2_W2_D4_Friday.services;

import dangelodavide.U2_W2_D4_Friday.Payloads.LoginDTO;
import dangelodavide.U2_W2_D4_Friday.entities.Dipendente;
import dangelodavide.U2_W2_D4_Friday.exceptions.UnauthorizedException;
import dangelodavide.U2_W2_D4_Friday.tools.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private JWTTools jwtTools;

    public String checkCredentialsAndGenerateToken(LoginDTO body) {
        Dipendente found = dipendenteService.findByEmail(body.email());
        if (found.getPassword().equals(body.password())) {
            return jwtTools.createToken(found);
        } else {
            throw new UnauthorizedException("Credenziali errate");
        }
    }

}
