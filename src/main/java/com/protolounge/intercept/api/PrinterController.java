/**
 * 
 */
package com.protolounge.intercept.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.protolounge.intercept.ProtoLoungeException;
import com.protolounge.intercept.domain.MVPPrinter;
import com.protolounge.intercept.service.PrinterService;

/**
 * @author stacydecker
 *
 */
@RestController
@RequestMapping("/printer")
public class PrinterController {

    @Autowired PrinterService printerService;
    /**
     * 
     */
    public PrinterController() {
    }

    @RequestMapping(
            value="/add",
            method=RequestMethod.POST,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE
            )    public void addMaterial(@RequestBody MVPPrinter printer){
        try {
            printerService.addPrinter(printer);
        } catch (ProtoLoungeException e) {
            // really need to add in logger stuff here... ;)
        }
    }

}
