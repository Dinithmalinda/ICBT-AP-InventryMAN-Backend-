package com.Dinithm.ICBT.Branches;

import com.Dinithm.ICBT.INVOICE.Invoce;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

public class BranchesController {
    BranchesRepository branchesRepository;
    public BranchesController(BranchesRepository branchesRepository){this.branchesRepository=branchesRepository;}
    @RequestMapping(
            value = "api/getall/branches",
            method = RequestMethod.POST)
    public List<Branches> GetAllBranches(@RequestBody Map<String, Object> payload)
            throws Exception {
        //  LocalDate lt = LocalDate.now();System.out.println(lt);
        System.out.println(payload);
        List<Branches> invoices=branchesRepository.findAll();
        return invoices;}



}
