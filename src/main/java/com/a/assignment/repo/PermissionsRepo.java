package com.a.assignment.repo;

import com.a.assignment.model.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionsRepo extends JpaRepository<Permissions,Long> {

    public Permissions findByUserEmail(String email);
}
