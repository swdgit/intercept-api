/**
 * 
 */
package com.protolounge.intercept.service;

import java.util.List;

import com.protolounge.intercept.ProtoLoungeException;
import com.protolounge.intercept.domain.MVPPrinter;

/**
 * @author stacydecker
 *
 */
public interface PrinterService {

    public List<MVPPrinter> getAllPrinters() throws ProtoLoungeException;

    public MVPPrinter addPrinter(MVPPrinter printer) throws ProtoLoungeException;
    
    public MVPPrinter findByName(String name) throws ProtoLoungeException;
}
