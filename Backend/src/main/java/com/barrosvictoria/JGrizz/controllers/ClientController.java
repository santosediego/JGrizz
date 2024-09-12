package com.barrosvictoria.JGrizz.controllers;

import com.barrosvictoria.JGrizz.dto.ClientDTO;
import com.barrosvictoria.JGrizz.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ClientService clientService;

    @GetMapping
    public Page<ClientDTO> findAll(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "network", defaultValue = "") String network,
            Pageable pageable) {
        return clientService.findAll(name.trim(), network.trim(), pageable);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        ClientDTO dto = clientService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert(@Valid @RequestBody ClientDTO dto) {
        ClientDTO newDTO = clientService.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.ok().body(newDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @Valid @RequestBody ClientDTO dto) {
        ClientDTO newDTO = clientService.update(id, dto);

        return ResponseEntity.ok().body(newDTO);
    }
}
