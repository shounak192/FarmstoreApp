package com.cg.farmstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.farmstore.entities.ItemsOrdered;

@Repository
public interface IItemsOrderedRepository extends JpaRepository<ItemsOrdered, Integer> {

	@Query(value = "select * from items_ordered where item_id =?1", nativeQuery = true)
	List<ItemsOrdered> viewOrdersOfItemId(int itemId);
}
