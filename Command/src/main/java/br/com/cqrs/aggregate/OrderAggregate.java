package br.com.cqrs.aggregate;


import br.com.cqrs.command.CreateOrderCommand;
import br.com.cqrs.event.OrderCreatedEvent;
import br.com.cqrs.handler.OrderCommandHandler;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
@Getter
@Setter
public class OrderAggregate {

    private static Logger logger = LoggerFactory.getLogger(OrderAggregate.class);


    @AggregateIdentifier
    private String orderId;
    private String product;
    private int quantity;

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command) {
        logger.info("Handling CreateOrderCommand for orderId: {}", command.getOrderId());
        apply(OrderCreatedEvent.of(command));
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        this.orderId = event.getOrderId();
        this.product = event.getProduct();
        this.quantity = event.getQuantity();
    }

}
