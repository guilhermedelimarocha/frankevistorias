package com.frankevistorias.api.usuario;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/fvi")
public class UsuarioController {

    @Autowired
	private UsuarioService usuarioService;
    @Autowired
    private PasswordEncoder encoder;


	@PostMapping("/usuario")
    public ResponseEntity<Long> save(@RequestBody  @Valid UsuarioEntity usuarioEntity) throws NotFoundException{
        Optional<UsuarioEntity> usuario = usuarioService.findByEmail(usuarioEntity.getEmail());
        if(usuario.isPresent()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(usuario.get().getId());
        }
		return ResponseEntity.ok().body(usuarioService.save(usuarioEntity));

    }

	@PutMapping("/usuario")
    public ResponseEntity<Long> update(@RequestBody UsuarioEntity usuarioEntity) throws NotFoundException{
        return ResponseEntity.ok().body(usuarioService.save(usuarioEntity));
    }

    @GetMapping("/login")
    public ResponseEntity<Boolean> login(@RequestParam String email, @RequestParam String senha) {
        
        
        Optional<UsuarioEntity> usuario = usuarioService.findByEmail(email);
        if(!usuario.isPresent()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        boolean valid = false;
        valid = encoder.matches(senha, usuario.get().getSenha());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {

        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            erros.put(fieldName, errorMessage);
        });

        return erros;
    }

}