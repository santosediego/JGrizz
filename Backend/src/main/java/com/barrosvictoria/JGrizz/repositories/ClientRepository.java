package com.barrosvictoria.JGrizz.repositories;

import com.barrosvictoria.JGrizz.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
