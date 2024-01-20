package com.kk.costcalc.repo;

import com.kk.costcalc.entity.Region;
import com.kk.costcalc.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
    boolean existsByRegNumber(String regNumber);

    List<Shop> findAllByRegion(Region region);
}
