/**
 * 
 */
package com.protolounge.intercept.service;

import java.util.List;

import com.protolounge.intercept.ProtoLoungeException;
import com.protolounge.intercept.domain.MVPPrintSpecification;

/**
 * @author stacydecker
 *
 */
public interface PrintSpecificationService {

    public List<MVPPrintSpecification> getAllPrintSpecifications() throws ProtoLoungeException;
    public MVPPrintSpecification addPrintSpecification(MVPPrintSpecification mvpPrintSpecification) throws ProtoLoungeException;
}
