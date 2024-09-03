package br.com.cqrs.controllers;

import br.com.cqrs.command.CreateOrderCommand;
import br.com.cqrs.dtos.OrderCreateDTO;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderCommandController {

    private static Logger logger = LoggerFactory.getLogger(OrderCommandController.class);

    private final CommandGateway commandGateway;

    @PostMapping
    public CompletableFuture<String> createOrder(@RequestBody OrderCreateDTO orderCreateDTO) {
        String orderId = UUID.randomUUID().toString();
        logger.info("Received request to create order with ID: {}", orderId);
        CreateOrderCommand command = new CreateOrderCommand(orderId, orderCreateDTO.getProduct(), orderCreateDTO.getQuantity());
        return commandGateway.send(command).thenApply(result -> {
                    logger.info("Order with ID: {} successfully created", orderId);
                    return orderId;
                })
                .exceptionally(ex -> {
                    logger.error("Error creating order with ID: {}", orderId, ex);
                    return "Unknown error";
                });
    }
}
