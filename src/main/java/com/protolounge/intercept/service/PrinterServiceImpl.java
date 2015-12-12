/**
 * 
 */
package com.protolounge.intercept.service;

import java.util.List;

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
            MVPPrinter e = printerRepository.findByName(printer.getName());
            if (e != null) {
                printer = e;
            } else {
                printer =  printerRepository.save(printer);
            }
        } catch(javax.persistence.RollbackException e) {
            // how to find out the reason for the rollback exception?
            System.out.println(e.getMessage());
        }
        return printer;
    }

    @Override
    public MVPPrinter findByName(String name) throws ProtoLoungeException {
        MVPPrinter printer = printerRepository.findByName(name);
        return printer;
    }
}
