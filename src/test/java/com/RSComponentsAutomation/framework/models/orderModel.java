package com.RSComponentsAutomation.framework.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class orderModel {
     private String itemPrice;              //when more items are to be added to basket, items params can be increased and named as item1Price,item2Price, etc.
     private String itemStockNo;
     private String itemQty = "1";          //setting this to 1 as per default
     private String grandTotal;
}
