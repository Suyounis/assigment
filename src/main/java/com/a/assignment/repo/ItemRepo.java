package com.a.assignment.repo;

import com.a.assignment.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepo extends JpaRepository<Item,Long> {
    public Optional<Item> findByName(String name);
}
