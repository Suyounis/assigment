package com.a.assignment.repo;

import com.a.assignment.model.PermissionGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionsGroupRepo extends JpaRepository<PermissionGroup,Long> {
}
