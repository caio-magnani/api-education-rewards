package com.lab3.universitycoins.controller;

import com.lab3.universitycoins.model.user.Institution;
import com.lab3.universitycoins.model.user.Partner;
import com.lab3.universitycoins.model.user.Suport;
import com.lab3.universitycoins.repository.InstitutionRepository;
import com.lab3.universitycoins.repository.PartnerRepository;
import com.lab3.universitycoins.repository.SuportRepository;
import com.lab3.universitycoins.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suport")
public class SuportController {

    @Autowired
    UserRepository users;

    @Autowired
    SuportRepository suports;

    @Autowired
    PartnerRepository partners;

    @Autowired
    InstitutionRepository institutions;

    @PostMapping
    public boolean insert(@RequestBody Suport suport) {
        if (users.existsByEmail(suport.getEmail())) {
            return false;
        }
        suports.save(suport);
        return true;
    }

    @PostMapping("/new-partner")
    public boolean insert(@RequestBody Partner partner) {
        boolean exist = users.existsByCnpj(partner.getCnpj(), partners, institutions)
                || users.existsByEmail(partner.getEmail());
        if (exist) {
            return false;
        }
        partners.save(partner);
        return true;
    }

    @PostMapping("/new-instution")
    public boolean insert(@RequestBody Institution institution) {
        boolean exist = users.existsByCnpj(institution.getCnpj(), partners, institutions)
                || users.existsByEmail(institution.getEmail());
        if (exist)
            return false;
        institutions.save(institution);
        return true;
    }
}
