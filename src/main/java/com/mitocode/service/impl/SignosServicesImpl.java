/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.service.impl;

import com.mitocode.model.Signos;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.ISignosRepo;
import com.mitocode.service.ISignosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author cesar
 */
@Service
public class SignosServicesImpl extends CRUDImpl<Signos, Integer> implements ISignosService {

    @Autowired
    private ISignosRepo repo;

    @Override
    protected IGenericRepo<Signos, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Signos> listarPageable(Pageable pageable) {
        return repo.findAll(pageable);
    }

}
