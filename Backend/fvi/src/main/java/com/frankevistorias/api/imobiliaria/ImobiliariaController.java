package com.frankevistorias.api.imobiliaria;

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
@RequestMapping(value="/fvi")
public class ImobiliariaController {

    @Autowired
	private ImobiliariaService imobiliariaService;

	@PostMapping("/imobiliaria")
    public ResponseEntity<Long> save(@RequestBody @Valid ImobiliariaEntity imobiliariaEntity) throws NotFoundException{
		return ResponseEntity.ok().body(imobiliariaService.save(imobiliariaEntity));

    }

	@PutMapping("/imobiliaria")
    public ResponseEntity<Long> update(@RequestBody ImobiliariaEntity imobiliariaEntity) throws NotFoundException{
        return ResponseEntity.ok().body(imobiliariaService.save(imobiliariaEntity));
    }

	@GetMapping("/imobiliaria")
    public ResponseEntity<List<ImobiliariaEntity>> findAll() {
        return ResponseEntity.ok().body(imobiliariaService.findAll());
    }

    @DeleteMapping("/imobiliaria/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) throws NotFoundException {
		imobiliariaService.delete(id);
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
    
}