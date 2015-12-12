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
        return printerRepository.save(printer);
    }
}
