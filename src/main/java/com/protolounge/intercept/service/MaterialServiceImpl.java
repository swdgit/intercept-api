/**
 * 
 */
package com.protolounge.intercept.service;

import java.util.List;

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
}
