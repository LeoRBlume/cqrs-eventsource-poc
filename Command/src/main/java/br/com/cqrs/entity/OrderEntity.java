package br.com.cqrs.entity;

import br.com.cqrs.event.OrderCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    @Id
    private String orderId;
    private String product;
    private int quantity;

    public static OrderEntity of(OrderCreatedEvent event) {
        return new OrderEntity(event.getOrderId(), event.getProduct(), event.getQuantity());
    }
}
