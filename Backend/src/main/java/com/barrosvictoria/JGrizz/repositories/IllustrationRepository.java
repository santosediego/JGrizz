package com.barrosvictoria.JGrizz.repositories;

import com.barrosvictoria.JGrizz.entities.Illustration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IllustrationRepository extends JpaRepository<Illustration, Long> {

    @Query("SELECT obj FROM Illustration obj " +
            "WHERE (description ILIKE CONCAT('%',:description,'%') OR :description IS NULL)")
    Page<Illustration> find(String description, Pageable pegeable);
}
