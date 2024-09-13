package com.barrosvictoria.JGrizz.services;

import com.barrosvictoria.JGrizz.dto.IllustrationDTO;
import com.barrosvictoria.JGrizz.entities.Illustration;
import com.barrosvictoria.JGrizz.repositories.IllustrationRepository;
import com.barrosvictoria.JGrizz.services.exceptions.DatabaseException;
import com.barrosvictoria.JGrizz.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;

@Service
public class IllustrationService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private IllustrationRepository illustrationRepository;

    @Transactional(readOnly = true)
    public Page<IllustrationDTO> findAll(String description, Pageable pegeable) {

        if (description.isEmpty()) description = null;
        Page<Illustration> paged = illustrationRepository.find(description, pegeable);
        return paged.map(x -> new IllustrationDTO(x));
    }

    @Transactional(readOnly = true)
    public IllustrationDTO findById(Long id) {
        Optional<Illustration> obj = illustrationRepository.findById(id);
        Illustration entity = obj.orElseThrow(() -> new ResourceNotFoundException("Illustration not found"));
        return new IllustrationDTO(entity);
    }

    @Transactional
    public IllustrationDTO insert(@Valid IllustrationDTO dto) {
        Illustration entity = new Illustration();
        copyDtoToEntity(dto, entity);

        entity = illustrationRepository.save(entity);
        return new IllustrationDTO(entity);
    }

    @Transactional
    public IllustrationDTO update(Long id, @Valid IllustrationDTO dto) {
        try {
            Illustration entity = illustrationRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);

            entity = illustrationRepository.save(entity);
            return new IllustrationDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {

        if (!illustrationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
        try {
            illustrationRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    private void copyDtoToEntity(IllustrationDTO dto, Illustration entity) {
        entity.setDescription(dto.getDescription());
        entity.setComments(dto.getComments());
        entity.setPrice(dto.getPrice());
    }
}
