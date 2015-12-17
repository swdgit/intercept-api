/**
 * 
 */
package com.protolounge.intercept.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.protolounge.intercept.ProtoLoungeException;
import com.protolounge.intercept.domain.MVPPrintSpecification;
import com.protolounge.intercept.service.PrintSpecificationService;

/**
 * @author stacydecker
 *
 */
@RestController
@RequestMapping("/ps")
public class PrintSpecificationController {
    
    private final Logger log = LoggerFactory.getLogger(PrintSpecificationController.class);
    
    @Autowired PrintSpecificationService printSpecificationService;
    
    /**
     * 
     */
    public PrintSpecificationController() {
    }
    
    @RequestMapping("/all")
    public List<MVPPrintSpecification> getPrintSpecification() {
        List<MVPPrintSpecification> materials = new ArrayList<>();
        try {
            return printSpecificationService.getAllPrintSpecifications();
        } catch (ProtoLoungeException e) {
            log.error(e.getMessage());
        }
        return materials;
    }
    
    @RequestMapping(
            value="/add",
            method=RequestMethod.POST,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public MVPPrintSpecification addMaterial(@RequestBody MVPPrintSpecification printSpec){
        try {
            printSpec = printSpecificationService.addPrintSpecification(printSpec);
        } catch (ProtoLoungeException e) {
            log.error(e.getMessage());
        }
        return printSpec;
    }

}
