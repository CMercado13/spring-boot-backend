/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.controller;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Signos;
import com.mitocode.service.ISignosService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author cesar
 */
@RestController
@RequestMapping("/signos")
public class SignosController {

    @Autowired
    private ISignosService service;

    @GetMapping()
    public ResponseEntity<List<Signos>> listar() throws Exception {
        List<Signos> listar = service.listar();
        return new ResponseEntity<List<Signos>>(listar, HttpStatus.OK);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Signos>> listarPageable(Pageable pageable) throws Exception {
        Page<Signos> listSignos = service.listarPageable(pageable);
        return new ResponseEntity<Page<Signos>>(listSignos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Signos> modificar(@PathVariable("id") Integer id) throws Exception {
        Signos obj = service.listarPorId(id);
        return new ResponseEntity<Signos>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody Signos signos) throws Exception {
        Signos obj = service.registrar(signos);

        //localhost:8080/pacientes/5
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdSigno()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Signos> modificar(@Valid @RequestBody Signos signos) throws Exception {
        Signos obj = service.modificar(signos);
        return new ResponseEntity<Signos>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        Signos obj = service.listarPorId(id);
        if (obj.getIdSigno() == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
