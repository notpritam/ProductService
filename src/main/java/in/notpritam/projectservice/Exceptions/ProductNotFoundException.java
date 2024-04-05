package in.notpritam.projectservice.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductNotFoundException extends RuntimeException{
    private Long id;
    public ProductNotFoundException(String s, Long id) {
        super(s);
        this.id = id;
    }
}
