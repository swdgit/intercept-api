/**
 * 
 */
package com.protolounge.intercept.service;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.protolounge.intercept.domain.MVPPrinter;

/**
 * @author stacydecker
 *
 */
public interface PrinterRepository extends Repository<MVPPrinter, Long> {
    public List<MVPPrinter> findAll(); 
}
