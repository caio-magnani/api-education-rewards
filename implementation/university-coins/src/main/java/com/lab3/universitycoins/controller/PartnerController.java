package com.lab3.universitycoins.controller;

import com.lab3.universitycoins.model.user.Partner;
import com.lab3.universitycoins.repository.PartnerRepository;
import com.lab3.universitycoins.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partner")
public class PartnerController {

    @Autowired
    UserRepository users;

    @Autowired
    PartnerRepository partners;

    @PostMapping
    public boolean insert(@RequestBody Partner partner) {
        if (users.existsByEmail(partner.getEmail())) {
            return false;
        }
        partners.save(partner);
        return true;
    }

    @PostMapping("/update-partner")
    public void update(@RequestBody Partner partner) {
        partners.save(partner);
    }

    @PostMapping("/delete-partner")
    public void delete(@RequestBody Partner suport) {
        partners.delete(suport);
    }

}