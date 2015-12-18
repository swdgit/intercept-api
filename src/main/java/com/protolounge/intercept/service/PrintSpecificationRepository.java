/**
 * 
 */
package com.protolounge.intercept.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.protolounge.intercept.domain.MVPPrintSpecification;

/**
 * @author stacydecker
 *
 */
public interface PrintSpecificationRepository extends Repository<MVPPrintSpecification, Long> {
    
    public List<MVPPrintSpecification> findAll(); 
    
    public MVPPrintSpecification save(MVPPrintSpecification mvpPrintSpecification);

    @Query("SELECT mps FROM MVPPrintSpecification mps where mps.mvpPrinter.mvpPrinterId = :mvpPrinterId and mps.mvpMaterial.mvpMaterialId = :mvpMaterialId")
    public List<MVPPrintSpecification> findByMVPPrinterIdAndMVPMaterialId(@Param("mvpPrinterId") int mvpPrinterId, 
                                                                          @Param("mvpMaterialId") int mvpMaterialId);
    
    @Query("Select mps from MVPPrintSpecification mps where mps.mvpPrinter.mvpPrinterId = :mvpPrinterId") 
    public List<MVPPrintSpecification> findByMvpPrinterId(@Param("mvpPrinterId") int mvpPrinterId);

    @Query("Select mps from MVPPrintSpecification mps where mps.mvpMaterial.mvpMaterialId = :mvpMaterialId") 
    public List<MVPPrintSpecification> findByMvpMaterialId(@Param("mvpMaterialId") int mvpMaterialId);
    
    public MVPPrintSpecification findByMvpPrintSpecificationId(int mvpPrintSpecificationId);
}
