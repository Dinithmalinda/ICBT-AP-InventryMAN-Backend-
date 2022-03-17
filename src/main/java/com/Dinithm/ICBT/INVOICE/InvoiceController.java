package com.Dinithm.ICBT.INVOICE;

import com.Dinithm.ICBT.USER.UserController;
import com.Dinithm.ICBT.USER.Users;
import com.Dinithm.ICBT.USER.UsersRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

@Configuration
@RestController
public class InvoiceController {
    InvoiceRepository invoiceRepository;
    @Autowired
    public InvoiceController (InvoiceRepository invoiceRepository){
        this.invoiceRepository=invoiceRepository;
    }
    @RequestMapping(
            value = "api/getall/invoices",
            method = RequestMethod.POST)
    public List<Invoce> GetAllinvoices(@RequestBody Map<String, Object> payload)
            throws Exception {
      //  LocalDate lt = LocalDate.now();System.out.println(lt);
        System.out.println(payload);
        List<Invoce> invoices=invoiceRepository.findAll();
        return invoices;
    }
    @RequestMapping(
            value = "api/setnew/invoices",
            method = RequestMethod.POST)
    public List<Invoce> Setnewinvoices(@RequestBody Map<String, Object> payload)
            throws Exception {
         LocalDate lt = LocalDate.now();System.out.println(lt);
        System.out.println(payload);

        String dd=decodeuserdata(payload.get("userId").toString());
        String mobile[]=dd.split(":");
        System.out.println(mobile[2]);

Invoce invoce=new Invoce( parseInt(mobile[5]),parseInt(payload.get("branch").toString()),payload.get("items").toString(),LocalDate.now());
         invoiceRepository.save(invoce);
        return List.of(invoce);
    }

    private String decodeuserdata(String input){
        Base64 base64 = new Base64();
        String decodedString = new String(base64.decode(input.getBytes()));
        return decodedString;
    }


}
