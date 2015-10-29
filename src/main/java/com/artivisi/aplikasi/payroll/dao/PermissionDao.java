package com.artivisi.aplikasi.payroll.dao;

import com.artivisi.aplikasi.payroll.domain.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao extends PagingAndSortingRepository<Permission, String>{
    Permission findByValue(String value);
    Page<Permission> findByLabelContaining(String label, Pageable pageable);
    Page<Permission> findByValueContaining(String value, Pageable pageable);
}
