package com.frankevistorias.api.atendimento;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ilson Junior
 * @since 11/05/2022
 */

@RestController
@RequestMapping(value="/atendimento")
public class AtendimentoController {

    @Autowired
	private AtendimentoService atendimentoService;

	@PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody @Valid AtendimentoEntity atendimentoEntity) throws NotFoundException{
		return ResponseEntity.ok().body(atendimentoService.save(atendimentoEntity));

    }

	@PutMapping("/update")
    public ResponseEntity<Long> update(@RequestBody AtendimentoEntity atendimentoEntity) throws NotFoundException{
        return ResponseEntity.ok().body(atendimentoService.save(atendimentoEntity));
    }

	@GetMapping("/findAll")
    public ResponseEntity<List<AtendimentoEntity>> findAll() {
        return ResponseEntity.ok().body(atendimentoService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) throws NotFoundException {
		atendimentoService.delete(id);
        return ResponseEntity.ok("Deleted");
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

    @GetMapping("/findByReferenciaImovel/{referenciaImovel}")
    public ResponseEntity<List<AtendimentoEntity>> findByReferenciaImovel(@PathVariable("referenciaImovel") String referenciaImovel) {
        return ResponseEntity.ok().body(atendimentoService.findAll());
    }

    @GetMapping("/findByStatusEntityId/{statusEntityId}")
    public ResponseEntity<List<AtendimentoEntity>> findByStatusEntityId(@PathVariable("statusEntityId") Long statusEntityId) {
        return ResponseEntity.ok().body(atendimentoService.findAll());
    }

    @GetMapping("/findByResponsavel/{responsavel}")
    public ResponseEntity<List<AtendimentoEntity>> findByResponsavel(@PathVariable("responsavel") String responsavel) {
        return ResponseEntity.ok().body(atendimentoService.findAll());
    }
    
}