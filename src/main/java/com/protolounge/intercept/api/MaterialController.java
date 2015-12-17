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
import com.protolounge.intercept.domain.MVPMaterial;
import com.protolounge.intercept.service.MaterialService;

/**
 * @author stacydecker
 *
 */
@RestController
@RequestMapping("/material")
public class MaterialController {
    private final Logger log = LoggerFactory.getLogger(MaterialController.class);

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
            log.error(e.getMessage());
        }
        return materials;
    }
    
    @RequestMapping(
            value="/add",
            method=RequestMethod.POST,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public MVPMaterial addMaterial(@RequestBody MVPMaterial material){
        try {
            material = materialService.addMaterial(material);
        } catch (ProtoLoungeException e) {
            log.error(e.getMessage());
        }
        return material;
    }
}
