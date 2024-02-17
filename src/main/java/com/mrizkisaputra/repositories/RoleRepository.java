package com.mrizkisaputra.repositories;

import com.mrizkisaputra.model.entity.ApplicationRole;
import com.mrizkisaputra.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByAuthority(ApplicationRole authority);
}
