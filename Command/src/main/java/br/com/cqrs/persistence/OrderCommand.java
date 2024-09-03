package br.com.cqrs.persistence;


import br.com.cqrs.entity.OrderEntity;
import br.com.cqrs.event.OrderCreatedEvent;
import br.com.cqrs.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCommand {

    private final OrderRepository orderRepository;

    @EventHandler
    public void on(OrderCreatedEvent event) {
        orderRepository.save(OrderEntity.of(event));
    }


}
