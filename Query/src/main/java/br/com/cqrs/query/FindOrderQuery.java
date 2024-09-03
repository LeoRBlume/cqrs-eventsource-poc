package br.com.cqrs.query;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FindOrderQuery {
    private final String orderId;
}
