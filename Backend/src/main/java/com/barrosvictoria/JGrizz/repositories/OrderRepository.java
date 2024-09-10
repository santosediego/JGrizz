package com.barrosvictoria.JGrizz.repositories;

import com.barrosvictoria.JGrizz.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
