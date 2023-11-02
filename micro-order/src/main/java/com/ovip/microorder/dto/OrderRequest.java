package com.ovip.microorder.dto;

import com.ovip.microorder.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    public List<OrderLineItemsDto> orderLineItemsDtoList;
}
