package com.kk.costcalc.repo;

import com.kk.costcalc.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
    boolean existsByName(String name);

    boolean existsByCode(String code);
}
