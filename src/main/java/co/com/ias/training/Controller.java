package co.com.ias.training;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class Controller {

    @GetMapping
    public String getProducts() {
        return "Este es el método para consultar todos los productos";
    }

    @PostMapping
    public String createProduct() {
        return "Este es el método para crear un producto";
    }

    @PutMapping
    public String modifyProduct() {
        return "Este es el método para actualizar un producto";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "Este es el método para eliminar un producto";
    }
}
