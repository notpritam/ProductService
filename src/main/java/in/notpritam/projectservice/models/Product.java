package in.notpritam.projectservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Product {
    @Id
    private Long id;
    private String title;
    private String description;
    private Double price;
    @ManyToOne
    private Category category;
    private String image;

    // We can make this using @ALL Args Constructor

//    Product(Long id , String title, String description, Double price, Category category, String image){
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.price = price;
//        this.category = category;
//        this.image = image;
//    }


}
