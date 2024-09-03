package br.com.cqrs.controllers;

import br.com.cqrs.command.CreateOrderCommand;
import br.com.cqrs.dtos.OrderCreateDTO;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @PostMapping
    public CompletableFuture<String> createOrder(@RequestBody OrderCreateDTO orderCreateDTO) {
        String orderId = UUID.randomUUID().toString();
        CreateOrderCommand command = new CreateOrderCommand(orderId, orderCreateDTO.getProduct(), orderCreateDTO.getQuantity());
        return commandGateway.send(command);
    }

}
