package com.cg.farmstore.service;

import java.util.List;
import com.cg.farmstore.dto.OrdersPojo;
import com.cg.farmstore.entities.Orders;
import com.cg.farmstore.exception.ItemNotFoundException;

public interface IOrderService {

	public Orders addOrder(Orders o) throws ItemNotFoundException;

	public boolean cancelOrder(int OrderId);

	public List<OrdersPojo> listAllOrders();

	public Orders listOrderByOrderId(int orderId);

	public List<Orders> listOrderByItemId(int ItemId);

	public List<OrdersPojo> listOrderBySupplierName(String supplierName);

	public List<Orders> deleteOrder(Orders o);

}
