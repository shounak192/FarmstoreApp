package com.cg.farmstore.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.farmstore.entities.Category;
import com.cg.farmstore.entities.Item;

@Repository
public interface IItemRepository extends JpaRepository<Item, Integer> {

	@Query(value = "select items from Item items where items.itemCategory = :category")
	List<Item> findAllByCategory(@Param("category") Category c);

	@Query(value = "select * from itemtable where farmer_farmerid IN(select farmerid from farmertable where farmerid = ?1)", nativeQuery = true)
	public List<Item> findItemsByFarmerId(int farmerId);
}
