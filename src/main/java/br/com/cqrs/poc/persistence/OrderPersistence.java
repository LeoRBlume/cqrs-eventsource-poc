package br.com.cqrs.poc.persistence;

import br.com.cqrs.poc.dtos.OrderResponseDTO;
import br.com.cqrs.poc.entity.OrderEntity;
import br.com.cqrs.poc.event.OrderCreatedEvent;
import br.com.cqrs.poc.query.FindOrderQuery;
import br.com.cqrs.poc.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderPersistence {

    private final OrderRepository orderRepository;

    @EventHandler
    public void on(OrderCreatedEvent event) {
        orderRepository.save(OrderEntity.of(event));
    }

    @QueryHandler
    public OrderResponseDTO handle(FindOrderQuery query) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(query.getOrderId());
        return orderEntity.map(OrderResponseDTO::of).orElseThrow(RuntimeException::new);
    }
}
