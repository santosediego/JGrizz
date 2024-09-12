package com.barrosvictoria.JGrizz.repositories;

import com.barrosvictoria.JGrizz.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT obj FROM Client obj " +
            "WHERE (name ILIKE CONCAT('%',:name,'%') OR :name IS NULL) " +
            "AND (network ILIKE CONCAT('%',:network,'%') OR :network IS NULL)")
    Page<Client> find(String name, String network, Pageable pageable);
}
