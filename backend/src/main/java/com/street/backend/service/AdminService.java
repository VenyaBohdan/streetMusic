package com.street.backend.service;

import com.street.backend.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AdminService {

    Optional<Admin> getAdminById(Long id);
    Iterable<Admin> getAllAdmins();
    Admin saveAdmin(Admin admin);
    void deleteAdmin(Long id);

}
