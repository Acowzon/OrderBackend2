package com.OrderManagement.test.serviceImpl;

import com.OrderManagement.test.dto.OrderDTO;
import com.OrderManagement.test.entity.OrderBean;
import com.OrderManagement.test.mapper.OrderMapper;
import com.OrderManagement.test.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public int createOrder(String userID, String itemID, int num,double price,String sellerID) {
        return this.orderMapper.createOrder(userID,itemID,num,price,sellerID);
    }

    @Override
    public int deleteOrder(String orderID) {
        return this.orderMapper.deleteOrder(orderID);
    }

    @Override
    public int updateOrderStatus(String orderID, int status) {
        return 0;
    }

    @Override
    public int updateOrderItem(String orderID, String itemID, int num) {
        return 0;
    }


    @Override
    public OrderDTO[] showOrderList(String userID) {
        List<OrderBean> orderBeanList = this.orderMapper.showOrderList(userID);
        return this.orderMapper.showOrderList(userID).stream().map(order -> {
            OrderDTO orderDTO = new OrderDTO();
            BeanUtils.copyProperties(order,orderDTO);
            return orderDTO;
        }).toArray(OrderDTO[]::new);
    }

    @Override
    public OrderDTO showOrderDetails(String orderID) {
        OrderBean orderBean = this.orderMapper.showOrderDetails(orderID);
        orderBean.setTotalCost(orderBean.getItemPrice()*orderBean.getItemNumber());
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderBean,orderDTO);
        return  orderDTO;
    }
}
