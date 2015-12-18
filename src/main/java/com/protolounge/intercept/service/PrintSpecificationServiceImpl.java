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
import com.protolounge.intercept.domain.MVPPrintSpecification;

/**
 * @author stacydecker
 *
 */
@Component
@Transactional
public class PrintSpecificationServiceImpl implements PrintSpecificationService {
    
    private final Logger log = LoggerFactory.getLogger(PrintSpecificationServiceImpl.class);
    
    private final PrintSpecificationRepository printSpecificationRepository;
        
    /**
     * 
     */
    @Autowired
    public PrintSpecificationServiceImpl(PrintSpecificationRepository printSpecificationRepository) {
        this.printSpecificationRepository = printSpecificationRepository;
    }

    /* (non-Javadoc)
     * @see com.protolounge.intercept.service.PrintSpecificationService#getAllPrintSpecifications()
     */
    @Override
    public List<MVPPrintSpecification> getAllPrintSpecifications() throws ProtoLoungeException {
        return printSpecificationRepository.findAll();
    }

    @Override
    public MVPPrintSpecification addPrintSpecification(MVPPrintSpecification mvpPrintSpecification) throws ProtoLoungeException {
        
        // ugh... if the printer id and material id are there we can just add a new spec. Ah... the title needs to be unique... Can we use that.
        try {
            mvpPrintSpecification = printSpecificationRepository.save(mvpPrintSpecification);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return mvpPrintSpecification;
    }

    @Override
    public List<MVPPrintSpecification> getPrinterSpecs(int mvpPrinterId, int mvpMaterialId) throws ProtoLoungeException {
        return printSpecificationRepository.findByMVPPrinterIdAndMVPMaterialId(mvpPrinterId, mvpMaterialId);
    }
}