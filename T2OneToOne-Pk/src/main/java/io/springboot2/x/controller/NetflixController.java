package io.springboot2.x.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.springboot2.x.domain.NetflixAcc;
import io.springboot2.x.service.INetflixService;

@RestController
public class NetflixController {
    @Autowired
   private INetflixService service;

    @PostMapping(value = "/netflixAcc/gen")
    public boolean addUserAns(@RequestBody NetflixAcc netflixAcc){
        return service.generateNetflixAcc(netflixAcc);
    }

   
}
