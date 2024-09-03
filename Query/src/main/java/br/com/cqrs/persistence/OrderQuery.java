package br.com.cqrs.persistence;


import br.com.cqrs.dtos.OrderResponseDTO;
import br.com.cqrs.entity.OrderEntity;
import br.com.cqrs.query.FindOrderQuery;
import br.com.cqrs.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderQuery {

    private final OrderRepository orderRepository;


    @QueryHandler
    public OrderResponseDTO handle(FindOrderQuery query) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(query.getOrderId());
        return orderEntity.map(OrderResponseDTO::of).orElse(null);
    }
}
