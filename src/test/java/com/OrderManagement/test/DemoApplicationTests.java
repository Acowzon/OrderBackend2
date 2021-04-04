package com.OrderManagement.test;

import com.OrderManagement.test.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	OrderService orderService;

	@Test
	void contextLoads() {
		/*List<OrderBean> orderBeans = this.orderService.showOrderList(334455);
		for(OrderBean orderBean:orderBeans){
			System.out.println(orderBean.toString());
		}*/

		//OrderBean orderBean = this.orderService.showOrderDetails(5);
		//System.out.println(orderBean.toString());
	}

}
