package com.kk.costcalc.repo;

import com.kk.costcalc.entity.TransportCostManger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportCostManagerRepository extends JpaRepository<TransportCostManger, Integer> {
}
