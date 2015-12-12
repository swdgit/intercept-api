/**
 * 
 */
package com.protolounge.intercept.api;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/all")
    public List<MVPPrinter> getMaterials() {
        List<MVPPrinter> printers = new ArrayList<>();
        try {
            return printerService.getAllPrinters();
        } catch (ProtoLoungeException e) {
            
        }
        return printers;
    }
    
    @RequestMapping(
            value="/add",
            method=RequestMethod.POST,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public MVPPrinter addPrinter(@RequestBody MVPPrinter printer) {
        try {
            printer = printerService.addPrinter(printer);
        } catch (ProtoLoungeException e) {
            // really need to add in logger stuff here... ;)
        }
        return printer;
    }
}
