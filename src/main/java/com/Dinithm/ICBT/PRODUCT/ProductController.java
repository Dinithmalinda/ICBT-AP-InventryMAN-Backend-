package com.Dinithm.ICBT.PRODUCT;

import com.Dinithm.ICBT.INVOICE.Invoce;
import com.Dinithm.ICBT.INVOICE.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Configuration
@RestController
public class ProductController {

    ProductRepository productRepository;

    @Autowired
    public ProductController (ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    @RequestMapping(
            value = "api/getall/products",
            method = RequestMethod.POST)
    public List<Product> GetAllproducts(@RequestBody Map<String, Object> payload)
            throws Exception {
        //  LocalDate lt = LocalDate.now();System.out.println(lt);
        System.out.println(payload);

        List<Product> products=productRepository.findAll();

        System.out.println();
        return products;
    }
}
