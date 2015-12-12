/**
 * 
 */
package com.protolounge.intercept.service;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.protolounge.intercept.domain.MVPSoftware;

/**
 * @author stacydecker
 *
 */
public interface SoftwareRepository extends Repository<MVPSoftware, Long> {
    public List<MVPSoftware> findAll(); 
    public MVPSoftware save(MVPSoftware mvpSoftware);
    public MVPSoftware findByTitleAndVersion(String title, String version);
}
