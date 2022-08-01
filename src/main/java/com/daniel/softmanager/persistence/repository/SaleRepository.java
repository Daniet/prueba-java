package com.daniel.softmanager.persistence.repository;

import com.daniel.softmanager.persistence.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {


    @Query(value = "select " +
            "cast(p.id as varchar) id, p.name product, cast(sum(sp.quantity) as varchar) sale, " +
            "cast((p.price * sum(sp.quantity)) as varchar) total " +
            "from sale_product sp " +
            "inner join product p on p.id = sp.product_id " +
            "group by sp.product_id " +
            "order by sale desc",
            nativeQuery = true)
    public List<Object[]> getSaleReport();
}
