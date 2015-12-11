/**
 * 
 */
package com.protolounge.intercept.service;

import java.util.List;

import com.protolounge.intercept.ProtoLoungeException;
import com.protolounge.intercept.domain.MVPMaterial;

/**
 * @author stacydecker
 *
 */
public interface MaterialService {

    public List<MVPMaterial> getAllMaterials() throws ProtoLoungeException;
}
