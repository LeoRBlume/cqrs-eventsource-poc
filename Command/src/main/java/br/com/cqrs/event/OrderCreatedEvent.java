package br.com.cqrs.event;

import br.com.cqrs.command.CreateOrderCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderCreatedEvent {
    private final String orderId;
    private final String product;
    private final int quantity;

    public static OrderCreatedEvent of(CreateOrderCommand command) {
        return new OrderCreatedEvent(command.getOrderId(), command.getProduct(), command.getQuantity());
    }
}
