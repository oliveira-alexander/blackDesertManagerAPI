package com.bdomanager.infrastructure.adapt.repositories;

import com.bdomanager.infrastructure.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemJPARepository extends JpaRepository<ItemEntity, Long> {
    boolean existsByDescription(String description);
}
