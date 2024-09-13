package com.barrosvictoria.JGrizz.controllers;

import com.barrosvictoria.JGrizz.dto.IllustrationDTO;
import com.barrosvictoria.JGrizz.services.IllustrationService;
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
@RequestMapping(value = "/illustrations")
public class IllustrationController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private IllustrationService illustrationService;

    @GetMapping
    public Page<IllustrationDTO> findAll(
            @RequestParam(value = "description", defaultValue = "") String description,
            Pageable pegeable) {
        return illustrationService.findAll(description.trim(), pegeable);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<IllustrationDTO> findById(@PathVariable Long id) {
        IllustrationDTO dto = illustrationService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<IllustrationDTO> insert(@Valid @RequestBody IllustrationDTO dto) {
        IllustrationDTO newDTO = illustrationService.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.ok().body(newDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<IllustrationDTO> update(@PathVariable Long id, @Valid @RequestBody IllustrationDTO dto) {
        IllustrationDTO newDTO = illustrationService.update(id, dto);

        return ResponseEntity.ok().body(newDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<IllustrationDTO> delete(@PathVariable Long id) {
        illustrationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
