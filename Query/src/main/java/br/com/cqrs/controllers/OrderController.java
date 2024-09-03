package br.com.cqrs.controllers;


import br.com.cqrs.dtos.OrderResponseDTO;
import br.com.cqrs.query.FindOrderQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final QueryGateway queryGateway;


    @GetMapping("/{orderId}")
    public CompletableFuture<OrderResponseDTO> findOrder(@PathVariable("orderId") String orderId) {
        return queryGateway.query(
                new FindOrderQuery(orderId),
                ResponseTypes.instanceOf(OrderResponseDTO.class)
        );
    }

}
