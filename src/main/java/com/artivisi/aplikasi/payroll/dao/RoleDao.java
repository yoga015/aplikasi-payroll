package com.artivisi.aplikasi.payroll.dao;

import com.artivisi.aplikasi.payroll.domain.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends PagingAndSortingRepository<Role, String>{
    Role findByName(String name);
}
