package com.daniel.softmanager.persistence.repository;

import com.daniel.softmanager.persistence.entity.Stocktaking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StocktakingRepository extends JpaRepository<Stocktaking, Long> {

    @Query(value = "SELECT count(*) FROM STOCKTAKING where out is null and product_id = :product_id",
            nativeQuery = true)
    public Integer quantityAvailable(@Param("product_id") Long product_id);

    @Modifying
    @Query(value = "UPDATE STOCKTAKING SET OUT=NOW()  WHERE PRODUCT_ID = :product_id LIMIT :quantity", nativeQuery = true)
    public void changeAvailable(@Param("product_id") Long product_id, @Param("quantity") int quantity);
}
