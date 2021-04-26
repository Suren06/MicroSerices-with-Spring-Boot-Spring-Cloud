package com.ssm.department.service;

import com.ssm.department.entity.Department;
import com.ssm.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public Department findByDepartmentId(Long departmentId) {
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
