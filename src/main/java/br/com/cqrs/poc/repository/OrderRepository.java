package br.com.cqrs.poc.repository;

import br.com.cqrs.poc.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {
}
