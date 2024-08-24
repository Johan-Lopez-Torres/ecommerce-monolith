package org.johan.microservices.sqljpaqueryes.repository;

import org.johan.microservices.sqljpaqueryes.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


}
