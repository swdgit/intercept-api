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
import com.protolounge.intercept.domain.MVPSoftware;
import com.protolounge.intercept.service.SoftwareService;

/**
 * @author stacydecker
 *
 */
@RestController
public class SoftwareController {

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
            
        }
        return software;
    }
    
    @RequestMapping(
            value="/add",
            method=RequestMethod.POST,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE
            )    public void addMaterial(@RequestBody MVPSoftware software){
        try {
            softwareService.addSoftware(software);
        } catch (ProtoLoungeException e) {
            // really need to add in logger stuff here... ;)
        }
    }    
}
