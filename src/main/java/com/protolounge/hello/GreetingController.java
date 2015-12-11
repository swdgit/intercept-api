package com.protolounge.hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.protolounge.intercept.ProtoLoungeException;
import com.protolounge.intercept.domain.MVPMaterial;
import com.protolounge.intercept.service.MaterialService;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong    counter  = new AtomicLong();
    
    @Autowired
    MaterialService materialService;
    
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        try {
            List<MVPMaterial> materials = materialService.getAllMaterials();
            System.out.println("material count: " + materials.size());
        } catch (ProtoLoungeException e) {
            System.out.println(e.getMessage());
        }
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
