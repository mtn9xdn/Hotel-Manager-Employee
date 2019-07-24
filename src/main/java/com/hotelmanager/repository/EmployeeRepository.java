package com.hotelmanager.repository;

import com.hotelmanager.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Page<Employee> findAllByDeletedIsFalse(Pageable pageable);
    Page<Employee> findAllByDeletedIsFalseAndNameContaining(String name, Pageable pageable);
}
