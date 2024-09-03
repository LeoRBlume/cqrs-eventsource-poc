package br.com.cqrs.poc.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCreateDTO {
    private String product;
    private int quantity;
}
