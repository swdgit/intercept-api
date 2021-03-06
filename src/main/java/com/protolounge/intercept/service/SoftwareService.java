/**
 * 
 */
package com.protolounge.intercept.service;

import java.util.List;

import com.protolounge.intercept.ProtoLoungeException;
import com.protolounge.intercept.domain.MVPSoftware;

/**
 * @author stacydecker
 *
 */
public interface SoftwareService {

    public List<MVPSoftware> getAllSoftware() throws ProtoLoungeException;
    
    public MVPSoftware addSoftware(MVPSoftware mvpSoftware) throws ProtoLoungeException;
    
    public MVPSoftware findByTitleAndVersion(String title, String version) throws ProtoLoungeException;
}
