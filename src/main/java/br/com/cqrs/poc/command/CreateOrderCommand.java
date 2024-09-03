package br.com.cqrs.poc.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateOrderCommand {

    private final String orderId;
    private final String product;
    private final int quantity;

}
