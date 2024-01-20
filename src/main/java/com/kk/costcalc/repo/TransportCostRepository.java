package com.kk.costcalc.repo;

import com.kk.costcalc.entity.TransportCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportCostRepository extends JpaRepository<TransportCost, Integer> {




}
