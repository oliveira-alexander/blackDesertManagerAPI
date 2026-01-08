package com.bdomanager.Infrastructure.item.adapters.repository;

import com.bdomanager.Infrastructure.item.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemJPARepository extends JpaRepository<ItemEntity, Long> {
}
