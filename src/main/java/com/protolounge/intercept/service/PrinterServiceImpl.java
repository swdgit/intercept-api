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
import com.protolounge.intercept.domain.MVPPrinter;

/**
 * @author stacydecker
 *
 */
@Component
@Transactional
public class PrinterServiceImpl implements PrinterService {

    private final Logger log = LoggerFactory.getLogger(PrinterServiceImpl.class);
    private final PrinterRepository printerRepository;
    
    /**
     * 
     */
    @Autowired
    public PrinterServiceImpl(PrinterRepository printerRepository) {
        this.printerRepository = printerRepository;
    }

    /* (non-Javadoc)
     * @see com.protolounge.intercept.service.PrinterService#getAllPrinters()
     */
    @Override
    public List<MVPPrinter> getAllPrinters() throws ProtoLoungeException {
        return printerRepository.findAll();
    }

    @Override
    public MVPPrinter addPrinter(MVPPrinter printer) throws ProtoLoungeException {
        
        try {
            MVPPrinter foundPrinter = printerRepository.findByName(printer.getName());
            
            printer = foundPrinter != null ? foundPrinter :  printerRepository.save(printer); 
            
        } catch(Exception e) {
            log.error(e.getMessage());
        }
        return printer;
    }

    @Override
    public MVPPrinter findByName(String name) throws ProtoLoungeException {
        MVPPrinter printer = printerRepository.findByName(name);
        return printer;
    }
}
