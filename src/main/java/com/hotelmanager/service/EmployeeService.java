package com.hotelmanager.service;

import com.hotelmanager.dto.EmployeeDTO;
import com.hotelmanager.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    Page<Employee> findAllByDeletedIsFalse(Pageable pageable);
    Page<Employee> findAllByDeletedIsFalseAndNameContaining(String name, Pageable pageable);
    void create(EmployeeDTO employeeDTO);
    void update(EmployeeDTO employeeDTO);
    void delete(String id);
    EmployeeDTO findById(String id);

}
