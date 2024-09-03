package br.com.cqrs.dtos;

import br.com.cqrs.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderResponseDTO {
    private String orderId;
    private String product;
    private int quantity;

    public static OrderResponseDTO of(OrderEntity orderEntity) {
        return new OrderResponseDTO(orderEntity.getOrderId(), orderEntity.getProduct(), orderEntity.getQuantity());
    }
}
