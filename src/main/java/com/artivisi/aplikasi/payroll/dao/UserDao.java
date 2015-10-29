package com.artivisi.aplikasi.payroll.dao;

import com.artivisi.aplikasi.payroll.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends PagingAndSortingRepository<User, String>{
    
    public User findByUsername(String username);
    
}