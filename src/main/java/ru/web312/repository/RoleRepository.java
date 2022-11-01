package ru.web312.repository;

import ru.web312.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleRepository {

    List<Role> getAllRoles ();
    void addRole(Role role);
    Role findById(long id);
    Set<Role> findByIdRoles(List<Long>roles);
}
