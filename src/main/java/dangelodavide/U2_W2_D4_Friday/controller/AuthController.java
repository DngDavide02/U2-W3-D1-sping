package dangelodavide.U2_W2_D4_Friday.controller;

import dangelodavide.U2_W2_D4_Friday.Payloads.LoginDTO;
import dangelodavide.U2_W2_D4_Friday.services.AuthService;
import dangelodavide.U2_W2_D4_Friday.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping("/login")
    public LoginDTO login(@RequestBody LoginDTO body){
        String accessToken authService.checkCredentialsAndGenerateToken(body);
        return new LoginDTO(accessToken);
    }
}
