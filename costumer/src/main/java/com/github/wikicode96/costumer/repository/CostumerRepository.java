package com.github.wikicode96.costumer.repository;

import com.github.wikicode96.costumer.entity.CostumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepository extends JpaRepository<CostumerEntity, Integer> {
}
