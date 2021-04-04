package com.OrderManagement.test.service;

import com.OrderManagement.test.dto.OrderDTO;
import com.OrderManagement.test.entity.OrderBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {

    public int createOrder(String userID, String itemID, int num,double price,String sellerID);

    int deleteOrder(String orderID);

    int updateOrderStatus(String orderID,int status);

    int updateOrderItem(String orderID,String itemID,int num);

    OrderDTO[] showOrderList(@Param("userID") String userID);

    OrderDTO showOrderDetails(String orderID);
    
}
