package in.notpritam.projectservice.ExceptionHandlers;

import in.notpritam.projectservice.Exceptions.ProductNotFoundException;
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

        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDTO> handleArrayIndexOutOfBound(){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage("Something went wrong");
        exceptionDTO.setResolution("ArrayIndex Out of Bound Exceptions");

        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleProductNotFound(ProductNotFoundException productNotFoundException){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage("Invalid productID passed " + productNotFoundException.getId());
        exceptionDTO.setResolution("ProductNotFound Exception");

        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }
}
