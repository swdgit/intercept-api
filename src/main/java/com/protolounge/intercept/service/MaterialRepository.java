/**
 * 
 */
package com.protolounge.intercept.service;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.protolounge.intercept.domain.MVPMaterial;

/**
 * @author stacydecker
 *
 */
public interface MaterialRepository extends Repository<MVPMaterial, Long> {
    
    public List<MVPMaterial> findAll();
    
    public MVPMaterial save(MVPMaterial material);
    
    public MVPMaterial findByName(String name);
}
