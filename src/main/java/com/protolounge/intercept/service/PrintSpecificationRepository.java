/**
 * 
 */
package com.protolounge.intercept.service;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.protolounge.intercept.domain.MVPPrintSpecification;

/**
 * @author stacydecker
 *
 */
public interface PrintSpecificationRepository extends Repository<MVPPrintSpecification, Long> {
    public List<MVPPrintSpecification> findAll(); 
}
