package ru.web312.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.web312.model.Role;
import ru.web312.repository.RoleRepositoryImp;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImp implements RoleService {

    private final RoleRepositoryImp roleRepositoryImp;

    public RoleServiceImp(RoleRepositoryImp roleRepositoryImp) {
        this.roleRepositoryImp = roleRepositoryImp;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepositoryImp.getAllRoles();
    }


    @Override
    @Transactional
    public void addRole(Role role) {
        roleRepositoryImp.addRole(role);
    }

    @Override
    public Role findById(long id) {
        return roleRepositoryImp.findById(id);
    }

    @Override
    public Set<Role> findByIdRoles(List<Long> roles) {
        return roleRepositoryImp.findByIdRoles(roles);
    }
}
