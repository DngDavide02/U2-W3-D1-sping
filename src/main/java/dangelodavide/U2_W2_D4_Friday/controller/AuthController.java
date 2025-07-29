package dangelodavide.U2_W2_D4_Friday.controller;

import dangelodavide.U2_W2_D4_Friday.Payloads.DipendentePayload;
import dangelodavide.U2_W2_D4_Friday.Payloads.LoginDTO;
import dangelodavide.U2_W2_D4_Friday.Payloads.LoginRespDTO;
import dangelodavide.U2_W2_D4_Friday.Payloads.NewDipendenteRespDTO;
import dangelodavide.U2_W2_D4_Friday.entities.Dipendente;
import dangelodavide.U2_W2_D4_Friday.exceptions.ValidationException;
import dangelodavide.U2_W2_D4_Friday.services.AuthService;
import dangelodavide.U2_W2_D4_Friday.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping("/login")
    public LoginRespDTO login(@RequestBody LoginDTO body){
        String accessToken = authService.checkCredentialsAndGenerateToken(body);
        return new LoginRespDTO(accessToken);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public NewDipendenteRespDTO save(@RequestBody @Validated DipendentePayload payload, BindingResult validationResult){
        if (validationResult.hasErrors()){
            throw new ValidationException(validationResult.getFieldErrors()
                    .stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList());
        } else {
            Dipendente newDipendente = this.dipendenteService.save(Dipendente.fromPayload(payload));
            return new NewDipendenteRespDTO(newDipendente.getId());
        }
    }


}
