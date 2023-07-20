package com.devsuperior.dscommerce.entities;

import java.time.Instant;

public class Order {

    private Long id;
    private Instant moment;
    private OrderStatus status;
    private User client;

}
