package com.cg.farmstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.farmstore.dto.CredentialPojo;
import com.cg.farmstore.dto.FarmerPojo;
import com.cg.farmstore.dto.ItemPojo;
import com.cg.farmstore.dto.OrdersPojo;
import com.cg.farmstore.dto.SupplierPojo;
import com.cg.farmstore.entities.Credentials;
import com.cg.farmstore.entities.Farmer;
import com.cg.farmstore.entities.Item;
import com.cg.farmstore.entities.ItemsOrdered;
import com.cg.farmstore.entities.Orders;
import com.cg.farmstore.entities.Supplier;
import com.cg.farmstore.exception.ItemNotFoundException;
import com.cg.farmstore.exception.NoOrdersFoundException;
import com.cg.farmstore.repository.IItemRepository;
import com.cg.farmstore.repository.IItemsOrderedRepository;
import com.cg.farmstore.repository.IOrdersRepository;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrdersRepository orderRepository;

	@Autowired
	ItemServiceImpl itemServiceImpl;

	@Autowired
	IItemRepository iItemRepository;

	@Autowired
	IItemsOrderedRepository iItemsOrderedRepository;

//	public List<Orders> ordersTotal = new ArrayList<Orders>();

	@Override
	public boolean cancelOrder(int OrderId) {
		orderRepository.deleteById(OrderId);
		return true;

	}

	@Override
	public List<Orders> deleteOrder(Orders o) {
		List<ItemsOrdered> l = o.getItems();
		for (ItemsOrdered i3 : l) {
			int quantityOrdered = i3.getItemQuantity();
			Item item = iItemRepository.findById(i3.getItemId()).get();
			item.setItemQuantity(item.getItemQuantity() + quantityOrdered);
			iItemRepository.save(item);
		}		
		orderRepository.deleteById(o.getOrderId());
		List<Orders> li = orderRepository.findAll();
		return li;
//
//		if (order.isEmpty()) {
//			throw new NoOrdersFoundException("No orders found with this ID");
//		} else {
//			order.get().setDeleted(1);
//			for(int i=0; i< ordersTotal.size(); i++) {
//				if(ordersTotal.get(i).getOrderId()== ordersId)
//					ordersTotal.get(i).setDeleted(1);
//			}
//			orderRepository.save(order.get());
//
//		}
//		// List<Orders>allProduct = orderRepository.findAll();
//		// orderPojo =(ArrayList<OrderPojo>)(ArrayList<?>) (orderRepository.findAll());
//		List<Orders> allOrders = orderRepository.findAll();
//
//		List<OrdersPojo> allOrderPojo = new ArrayList<>();
//		for (Orders orders : allOrders) {
//			if (orders.getDeleted() != 1) {
//				OrdersPojo orderPojo = new OrdersPojo();
//				BeanUtils.copyProperties(orders, orderPojo);
//
//				Supplier supplier = orders.getSupplier();
//				SupplierPojo supplierPojo = new SupplierPojo();
//				BeanUtils.copyProperties(supplier, supplierPojo);
//				supplierPojo.setOrders(null);
//
//				List<Items> allItems = orders.getItems();
//				List<ItemPojo> allItemPojo = new ArrayList<>();
//				for (Item item : allItems) {
//					ItemPojo itemPojo = new ItemPojo();
//					BeanUtils.copyProperties(item, itemPojo);
//					allItemPojo.add(itemPojo);
//				}
//				orderPojo.setItems(allItemPojo);
//				orderPojo.setSupplier(supplierPojo);
//
//				allOrderPojo.add(orderPojo);
//
//				return allOrderPojo;
//			}

//		}
//		return allOrderPojo;

	}

	@Override
	public List<OrdersPojo> listAllOrders() {

//		List<Orders> allOrders = orderRepository.findAll();
//
//		List<OrdersPojo> allOrderPojo = new ArrayList<>();
//		for (Orders orders : allOrders) {
//			if (orders.getDeleted() != 1) {
//			System.out.println(orders.getDeleted());
//
//			OrdersPojo orderPojo = new OrdersPojo();
//			BeanUtils.copyProperties(orders, orderPojo);
//
//			Supplier supplier = orders.getSupplier();
//			SupplierPojo supplierPojo = new SupplierPojo();
//			BeanUtils.copyProperties(supplier, supplierPojo);
//			supplierPojo.setOrders(null);
//
//			List<Item> allItems = orders.getItems();
//			List<ItemPojo> allItemPojo = new ArrayList<>();
//			for (Item item : allItems) {
//				ItemPojo itemPojo = new ItemPojo();
//				BeanUtils.copyProperties(item, itemPojo);
//				allItemPojo.add(itemPojo);
//			}
//			orderPojo.setItems(allItemPojo);
//			orderPojo.setSupplier(supplierPojo);
//
//			allOrderPojo.add(orderPojo);
//			}
//		}
//		return allOrderPojo;
		return null;
	}

	@Override
	public Orders listOrderByOrderId(int orderId) {
		Orders o = orderRepository.findById(orderId).get();
		return o;
//		Orders orders = new Orders();
//		for(Orders o: ordersTotal) {
//			if(o.getOrderId()==orderId) 
//				orders = o;
//		}
//		OrdersPojo orderPojo = new OrdersPojo();
//		BeanUtils.copyProperties(orders, orderPojo);
//		Supplier supplier = orders.getSupplier();
//		SupplierPojo supplierPojo = new SupplierPojo();
//		BeanUtils.copyProperties(supplier, supplierPojo);
//		supplierPojo.setOrders(null);
//
//		List<Item> allItem = orders.getItems();
//		List<ItemPojo> allItemPojo = new ArrayList<>();
//		for (Item item : allItem) {
//			ItemPojo itemPojo = new ItemPojo();
//			BeanUtils.copyProperties(item, itemPojo);
//			allItemPojo.add(itemPojo);
//		}
//		orderPojo.setItems(allItemPojo);
//		System.out.println(orderPojo);
//
//		return orderPojo;
//		return null;

	}

	@Override
	public List<Orders> listOrderByItemId(int ItemId) {
		List<Orders> allOrders = orderRepository.findAll();
		List<Orders> filteredOrders = new ArrayList<>();
		for (Orders orders : allOrders) {
			for (ItemsOrdered itemsOrdered : orders.getItems()) {
				if (itemsOrdered.getItemId() == ItemId) {
					filteredOrders.add(orders);
				}
			}
		}
		return filteredOrders;
//		for (Orders order : allOrders) {
////			if (order.getDeleted() != 1) {
//			flag = false;
//			OrdersPojo orderPojo = new OrdersPojo();
//			SupplierPojo supplierPojo = new SupplierPojo();
//			Supplier supplier = order.getSupplier();
//			BeanUtils.copyProperties(order, orderPojo);
//			List<ItemsOrdered> item1 = order.getItems();
//			List<ItemPojo> allItemPojo = new ArrayList<>();
//			for (ItemsOrdered itemEntity : item1) {
//				ItemPojo itemPojo = new ItemPojo();
//				BeanUtils.copyProperties(itemEntity, itemPojo);
//				if (itemPojo.getItemId() == ItemId) {
//					allItemPojo.add(itemPojo);
//					flag = true;
//				}
//			}
//			if (flag == true) {
//				BeanUtils.copyProperties(supplier, supplierPojo);
//				orderPojo.setSupplier(supplierPojo);
//				orderPojo.setItems(allItemPojo);
//				allOrderPojo.add(orderPojo);
//			}
////			}
//		}
//		System.out.println(allOrderPojo);
//		return allOrderPojo;
	}

	@Override
	public List<OrdersPojo> listOrderBySupplierName(String supplierName) {
//		List<Orders> orderEntityList = orderRepository.listOrderBySupplierName(supplierName);
//		List<OrdersPojo> pojoList = new ArrayList<>();
//		for (Orders orders : orderEntityList) {
//			OrdersPojo orderPojo = new OrdersPojo();
//			BeanUtils.copyProperties(orders, orderPojo);
//
//			Supplier supplier = orders.getSupplier();
//			SupplierPojo supplierPojo = new SupplierPojo();
//			BeanUtils.copyProperties(supplier, supplierPojo);
//
//			supplierPojo.setOrders(null);
//
//			List<ItemsOrdered> allItems = orders.getItems();
//			List<ItemPojo> allItemPojo = new ArrayList<>();
//			for (Item item : allItems) {
//				ItemPojo itemPojo = new ItemPojo();
//				BeanUtils.copyProperties(item, itemPojo);
//				allItemPojo.add(itemPojo);
//			}
//			orderPojo.setItems(allItemPojo);
//
//			orderPojo.setSupplier(supplierPojo);
//
//			pojoList.add(orderPojo);
//		}
//		return pojoList;
		return null;

	}

	@Override
	public Orders addOrder(Orders o) throws ItemNotFoundException {
		System.out.println(o);
		for (ItemsOrdered item : o.getItems()) {
			int quantityOrdered = item.getItemQuantity();
			Item it = new Item();
			it = iItemRepository.findById(item.getItemId()).get();
			it.setItemQuantity(it.getItemQuantity() - quantityOrdered);
			iItemRepository.save(it);
			iItemsOrderedRepository.save(item);
		}
		Orders orders = orderRepository.save(o);
//		ordersTotal.add(orders);

		return orders;
	}

}
