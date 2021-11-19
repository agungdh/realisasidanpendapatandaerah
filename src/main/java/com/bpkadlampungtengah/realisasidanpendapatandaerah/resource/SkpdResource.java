package com.bpkadlampungtengah.realisasidanpendapatandaerah.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/skpd")
public class SkpdResource {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String sayHello() {
        return "Swagger Hello World";
    }
}
