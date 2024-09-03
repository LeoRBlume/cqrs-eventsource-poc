package br.com.cqrs.handler;


import br.com.cqrs.entity.OrderEntity;
import br.com.cqrs.event.OrderCreatedEvent;
import br.com.cqrs.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCommandHandler {

    private static Logger logger = LoggerFactory.getLogger(OrderCommandHandler.class);
    private final OrderRepository orderRepository;

    @EventHandler
    public void onOrderCreatedEvent(OrderCreatedEvent event) {
        logger.info("Handling OrderCreatedEvent for orderId: {}", event.getOrderId());
        orderRepository.save(OrderEntity.of(event));
        logger.info("Entity saved and new OrderValidationEvent launched for orderId: {}", event.getOrderId());
    }
}
