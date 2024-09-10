package com.barrosvictoria.JGrizz.repositories;

import com.barrosvictoria.JGrizz.entities.IllustrationOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IllustrationOrderRepository extends JpaRepository<IllustrationOrder, Long> {
}
