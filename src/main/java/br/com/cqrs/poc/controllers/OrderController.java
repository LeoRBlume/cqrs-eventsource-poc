package br.com.cqrs.poc.controllers;

import br.com.cqrs.poc.command.CreateOrderCommand;
import br.com.cqrs.poc.dtos.OrderCreateDTO;
import br.com.cqrs.poc.dtos.OrderResponseDTO;
import br.com.cqrs.poc.entity.OrderEntity;
import br.com.cqrs.poc.query.FindOrderQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{orderId}")
    public CompletableFuture<OrderResponseDTO> findOrder(@PathVariable("orderId") String orderId) {
        return queryGateway.query(
                new FindOrderQuery(orderId),
                ResponseTypes.instanceOf(OrderResponseDTO.class)
        );
    }

}
