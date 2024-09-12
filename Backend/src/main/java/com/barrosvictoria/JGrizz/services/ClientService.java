package com.barrosvictoria.JGrizz.services;

import com.barrosvictoria.JGrizz.dto.ClientDTO;
import com.barrosvictoria.JGrizz.entities.Client;
import com.barrosvictoria.JGrizz.repositories.ClientRepository;
import com.barrosvictoria.JGrizz.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;

@Service
public class ClientService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(String name, String network, Pageable pageable) {

        if (name.isBlank()) name = null;
        if (network.isBlank()) network = null;
        Page<Client> paged = clientRepository.find(name, network, pageable);
        return paged.map(x -> new ClientDTO(x));
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Optional<Client> obj = clientRepository.findById(id);
        Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        copyDtoToEntity(dto, entity);

        entity = clientRepository.save(entity);

        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id, @Valid ClientDTO dto) {
        try {
            Client entity = clientRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = clientRepository.save(entity);
            return new ClientDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    private void copyDtoToEntity(ClientDTO dto, Client entity) {

        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setNetwork(dto.getNetwork());
        entity.setPhone(dto.getPhone());
    }
}
