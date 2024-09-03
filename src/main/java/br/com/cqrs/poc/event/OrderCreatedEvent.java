package br.com.cqrs.poc.event;

import br.com.cqrs.poc.command.CreateOrderCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderCreatedEvent {
    private final String orderId;
    private final String product;
    private final int quantity;


    public static OrderCreatedEvent of(CreateOrderCommand command) {
        if (command.getQuantity() <= 0) {
            throw new RuntimeException("Quantidade <= 0");
        }
        return new OrderCreatedEvent(command.getOrderId(), command.getProduct(), command.getQuantity());
    }
}
