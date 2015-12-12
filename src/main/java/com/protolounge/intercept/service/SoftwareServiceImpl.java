/**
 * 
 */
package com.protolounge.intercept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.protolounge.intercept.ProtoLoungeException;
import com.protolounge.intercept.domain.MVPSoftware;

/**
 * @author stacydecker
 *
 */
@Component
@Transactional
public class SoftwareServiceImpl implements SoftwareService {

    private final SoftwareRepository softwareRepository;
        
    /**
     * 
     */
    @Autowired
    public SoftwareServiceImpl(SoftwareRepository SoftwareRepository) {
        this.softwareRepository = SoftwareRepository;
    }

    /* (non-Javadoc)
     * @see com.protolounge.intercept.service.SoftwareService#getAllSoftwares()
     */
    @Override
    public List<MVPSoftware> getAllSoftware() throws ProtoLoungeException {
        return softwareRepository.findAll();
    }

    @Override
    public MVPSoftware addSoftware(MVPSoftware mvpSoftware) throws ProtoLoungeException {
        try {
            MVPSoftware foundSoftware = softwareRepository.findByTitleAndVersion(mvpSoftware.getTitle(), mvpSoftware.getVersion());
            mvpSoftware = foundSoftware != null ? foundSoftware : softwareRepository.save(mvpSoftware);
        } catch (Exception e) {
        }
        
        return mvpSoftware;
    }

    @Override
    public MVPSoftware findByTitleAndVersion(String title, String version) throws ProtoLoungeException {
        return softwareRepository.findByTitleAndVersion(title, version);
    }
}
