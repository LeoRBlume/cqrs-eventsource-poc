package br.com.cqrs.controllers;


import br.com.cqrs.dtos.OrderResponseDTO;
import br.com.cqrs.query.FindOrderQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderQueryController {

    private static Logger logger = LoggerFactory.getLogger(OrderQueryController.class);

    private final QueryGateway queryGateway;

    @GetMapping("/{orderId}")
    public CompletableFuture<OrderResponseDTO> findOrder(@PathVariable("orderId") String orderId) {
        logger.info("Received request to find order by ID: {}", orderId);

        return queryGateway.query(
                new FindOrderQuery(orderId),
                ResponseTypes.instanceOf(OrderResponseDTO.class)
        );
    }

}
