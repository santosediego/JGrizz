package com.barrosvictoria.JGrizz.repositories;

import com.barrosvictoria.JGrizz.entities.ReceiptType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptTypeRepository extends JpaRepository<ReceiptType, Long> {
}
