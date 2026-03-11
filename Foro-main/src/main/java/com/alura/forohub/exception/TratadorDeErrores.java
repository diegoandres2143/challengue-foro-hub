package com.alura.forohub.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
        // Mensaje alternativo para recurso no encontrado
        return ResponseEntity.status(404).body("El recurso solicitado no fue hallado en el sistema.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DatosErrorValidacion>> tratarError400(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream().map(DatosErrorValidacion::nuevoMensaje).toList();
        return ResponseEntity.badRequest().body(errores);
    }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<DatosErrorValidacion> tratarNullPointerException(NullPointerException e){
        var errores = DatosErrorValidacion.mensajeNulo(e.getMessage());
        return ResponseEntity.badRequest().body(errores);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<DatosErrorValidacion> tratarErrorGeneral(RuntimeException e){
        var errores = DatosErrorValidacion.mensajeGeneral(e.getMessage());
        return ResponseEntity.badRequest().body(errores);
    }




    private record DatosErrorValidacion(String campo, String error) {
        // Mensaje de validación alternativo
        public static DatosErrorValidacion nuevoMensaje(FieldError error){
            return new DatosErrorValidacion(error.getField(), "Dato inválido: " + error.getDefaultMessage());
        }
        // Mensaje alternativo para NullPointer
        public static DatosErrorValidacion mensajeNulo(String msg){
            return new DatosErrorValidacion("nulo", "Se produjo un error inesperado: " + msg);
        }
        // Mensaje alternativo para RuntimeException
        public static DatosErrorValidacion mensajeGeneral(String msg){
            return new DatosErrorValidacion("general", "Ha ocurrido un problema en la aplicación: " + msg);
        }
    }


}
