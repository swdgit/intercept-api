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
import com.protolounge.intercept.domain.MVPSoftware;
import com.protolounge.intercept.service.SoftwareService;

/**
 * @author stacydecker
 *
 */
@RestController
public class SoftwareController {

    private final Logger log = LoggerFactory.getLogger(SoftwareController.class);
    @Autowired SoftwareService softwareService;
    
    /**
     * 
     */
    public SoftwareController() {
        // TODO Auto-generated constructor stub
    }

    @RequestMapping("/all")
    public List<MVPSoftware> getMaterials() {
        List<MVPSoftware> software = new ArrayList<>();
        try {
            return softwareService.getAllSoftware();
        } catch (ProtoLoungeException e) {
            log.error(e.getMessage());
        }
        return software;
    }
    
    @RequestMapping(
            value="/add",
            method=RequestMethod.POST,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public MVPSoftware addSoftware(@RequestBody MVPSoftware software){
        
        try {
            software = softwareService.addSoftware(software);
        } catch (ProtoLoungeException e) {
            log.error(e.getMessage());
        }
        return software;
    }    
}
