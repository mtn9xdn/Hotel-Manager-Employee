package com.hotelmanager.service.impl;

import com.hotelmanager.constants.AppConsts;
import com.hotelmanager.dto.EmployeeDTO;
import com.hotelmanager.entity.Employee;
import com.hotelmanager.repository.EmployeeRepository;
import com.hotelmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Page<Employee> findAllByDeletedIsFalse(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(),10,Sort.by("name").ascending());
        return employeeRepository.findAllByDeletedIsFalse(pageable);
    }
    @Override
    public Page<Employee> findAllByDeletedIsFalseAndNameContaining(String name, Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber(),10,Sort.by("name").ascending());
        return employeeRepository.findAllByDeletedIsFalseAndNameContaining(name, pageable);
    }

    @Override
    public void create(EmployeeDTO employeeDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
        LocalDate birthday = LocalDate.parse(employeeDTO.getBirthday());
        Employee employee = new Employee();
        employee.setEmployeeCode(employeeDTO.getEmployeeCode());
        employee.setBirthday(birthday);
        employee.setName(employeeDTO.getName());
        employee.setAddress(employeeDTO.getAddress());
        employee.setCMND(employeeDTO.getCMND());
        employee.setEmail(employeeDTO.getEmail());
        employee.setGender(employeeDTO.getGender());
        employee.setEmployeeGroup(employeeDTO.getEmployeeGroup());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setDeleted(Boolean.FALSE);
        employeeRepository.save(employee);

    }

    @Override
    public EmployeeDTO findById(String id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
            String birthday = employee.getBirthday().format(formatter);
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setEmployeeCode(employee.getEmployeeCode());
            employeeDTO.setBirthday(birthday);
            employeeDTO.setName(employee.getName());
            employeeDTO.setAddress(employee.getAddress());
            employeeDTO.setCMND(employee.getCMND());
            employeeDTO.setEmail(employee.getEmail());
            employeeDTO.setGender(employee.getGender());
            employeeDTO.setEmployeeGroup(employee.getEmployeeGroup());
            employeeDTO.setPhoneNumber(employee.getPhoneNumber());

            return employeeDTO;
        }
        return null;
    }

    @Override
    public void update(EmployeeDTO employeeDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
        LocalDate birthday = LocalDate.parse(employeeDTO.getBirthday());

        Employee employee = employeeRepository.findById(employeeDTO.getId()).orElse(null);

        employee.setEmployeeCode(employeeDTO.getEmployeeCode());
        employee.setBirthday(birthday);
        employee.setName(employeeDTO.getName());
        employee.setAddress(employeeDTO.getAddress());
        employee.setCMND(employeeDTO.getCMND());
        employee.setEmail(employeeDTO.getEmail());
        employee.setGender(employeeDTO.getGender());
        employee.setEmployeeGroup(employeeDTO.getEmployeeGroup());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setDeleted(Boolean.FALSE);
        employeeRepository.save(employee);

    }

    @Override
    public void delete(String id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        employee.setDeleted(true);
        employeeRepository.save(employee);

    }
}

