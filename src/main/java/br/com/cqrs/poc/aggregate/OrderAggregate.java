package br.com.cqrs.poc.aggregate;

import br.com.cqrs.poc.command.CreateOrderCommand;
import br.com.cqrs.poc.event.OrderCreatedEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
@Getter
@Setter
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;
    private String product;
    private int quantity;

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command) {
        apply(OrderCreatedEvent.of(command));
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        this.orderId = event.getOrderId();
        this.product = event.getProduct();
        this.quantity = event.getQuantity();
    }

}
