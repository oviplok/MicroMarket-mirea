package com.ovip.microorder.service;


import com.ovip.microorder.config.WebClientConfig;
import com.ovip.microorder.dto.InventoryResponse;
import com.ovip.microorder.dto.OrderLineItemsDto;
import com.ovip.microorder.dto.OrderRequest;
import com.ovip.microorder.model.Order;
import com.ovip.microorder.model.OrderLineItems;
import com.ovip.microorder.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);

        List<String> skuCodes =order.getOrderLineItemsList()
                .stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

        //Call Inventory, and place order if product is in stock
        //1:57:30
        InventoryResponse[] inventoryResponsesArray=webClientBuilder.build().get()
                .uri("http://localhost:8082/api/inventory"
                        ,uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                        .bodyToMono(InventoryResponse[].class)
                                .block();

       boolean allProductsInStock = Arrays
               .stream(inventoryResponsesArray)
               .allMatch(InventoryResponse::isInStock);

        if(allProductsInStock){
            orderRepository.save(order);
        }
        else {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
