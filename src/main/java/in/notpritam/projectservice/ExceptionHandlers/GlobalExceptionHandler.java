package in.notpritam.projectservice.ExceptionHandlers;

import in.notpritam.projectservice.dtos.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDTO> handleArthimeticExpection(){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage("Something went wrong");
        exceptionDTO.setResolution("Arithmetic Resollutions");

        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
        return response;
    }


    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDTO> handleArrayIndexOutOfBound(){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage("Something went wrong");
        exceptionDTO.setResolution("ArrayIndex Out of Bound Exceptions");

        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
        return response;
    }
}
