/**
 * 
 */
package com.protolounge.intercept.service;

import java.util.List;

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

    private final PrintSpecificationRepository PrintSpecificationRepository;
        
    /**
     * 
     */
    @Autowired
    public PrintSpecificationServiceImpl(PrintSpecificationRepository PrintSpecificationRepository) {
        this.PrintSpecificationRepository = PrintSpecificationRepository;
    }

    /* (non-Javadoc)
     * @see com.protolounge.intercept.service.PrintSpecificationService#getAllPrintSpecifications()
     */
    @Override
    public List<MVPPrintSpecification> getAllPrintSpecifications() throws ProtoLoungeException {
        return PrintSpecificationRepository.findAll();
    }
}
