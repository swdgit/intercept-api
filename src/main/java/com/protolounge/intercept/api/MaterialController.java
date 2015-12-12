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
import com.protolounge.intercept.domain.MVPMaterial;
import com.protolounge.intercept.service.MaterialService;

/**
 * @author stacydecker
 *
 */
@RestController
@RequestMapping("/materials")
public class MaterialController {
   
    @Autowired
    MaterialService materialService;
    
    /**
     * 
     */
    public MaterialController() {
    }

    @RequestMapping("/all")
    public List<MVPMaterial> getMaterials() {
        List<MVPMaterial> materials = new ArrayList<>();
        try {
            return materialService.getAllMaterials();
        } catch (ProtoLoungeException e) {
            
        }
        return materials;
    }
    
    @RequestMapping(
            value="/add",
            method=RequestMethod.POST,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE
            )    public void addMaterial(@RequestBody MVPMaterial material){
        try {
            materialService.addMaterial(material);
        } catch (ProtoLoungeException e) {
            // really need to add in logger stuff here... ;)
        }
    }
}
