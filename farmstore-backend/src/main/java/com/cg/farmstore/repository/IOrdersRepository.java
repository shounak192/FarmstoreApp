package com.cg.farmstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.farmstore.entities.ItemsOrdered;
import com.cg.farmstore.entities.Orders;

@Repository
public interface IOrdersRepository extends JpaRepository<Orders, Integer> {

	@Query(value = "select * from orders where supplier_id in(select supplier_id from supplier where supplier_name =?1)", nativeQuery = true)
	List<Orders> listOrderBySupplierName(String supplierName);

	@Query(value = "select * from orders where supplier_id in(select supplier_id from supplier where username =?1)", nativeQuery = true)
	List<Orders> listOrderByUserName(String userName);
	
	@Query(value = "select * from orders where supplier_supplier_id in(select supplier_id from supplier where supplier_id =?1)", nativeQuery = true)
	List<Orders> listOrderBySupplierId(int supplierId);
	
	@Query(value = "select * from orders where order_id =?1", nativeQuery = true)
	Optional<Orders> viewOrderByOrderId(int orderId);
	

}
