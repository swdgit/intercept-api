/**
 * 
 */
package com.protolounge.intercept.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.protolounge.intercept.ProtoLoungeException;
import com.protolounge.intercept.domain.MVPMaterial;

/**
 * @author stacydecker
 *
 */
@Component
@Transactional
public class MaterialServiceImpl implements MaterialService {

    private final Logger log = LoggerFactory.getLogger(MaterialServiceImpl.class);

    private final MaterialRepository materialRepository;
        
    /**
     * 
     */
    @Autowired
    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    /* (non-Javadoc)
     * @see com.protolounge.intercept.service.MaterialService#getAllMaterials()
     */
    @Override
    public List<MVPMaterial> getAllMaterials() throws ProtoLoungeException {
        return materialRepository.findAll();
    }

    @Override
    public MVPMaterial addMaterial(MVPMaterial material) throws ProtoLoungeException {
        
        try {
            MVPMaterial foundMaterial = findByName(material.getName());
            material = foundMaterial != null ? foundMaterial : materialRepository.save(material);
        } catch (Exception e) {
            // logging here.
            log.error(e.getMessage());
        }
        return material;
    }

    @Override
    public MVPMaterial findByName(String name) throws ProtoLoungeException {
        return materialRepository.findByName(name);
    }
}
