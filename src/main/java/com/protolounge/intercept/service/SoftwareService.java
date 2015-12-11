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

    public List<MVPSoftware> getAllSoftwares() throws ProtoLoungeException;
}
