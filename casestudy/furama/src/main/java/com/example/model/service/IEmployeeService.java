package com.example.model.service;

import com.example.model.entity.employee.Division;
import com.example.model.entity.employee.EducationDegree;
import com.example.model.entity.employee.Employee;
import com.example.model.entity.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAllSearchName(Pageable pageable, String keyword);

    Employee findById(Integer id);

    void save(Employee employee);

    void remove(Integer id);

    List<Position> listPosition();
    List<EducationDegree> listEdu();
    List<Division> listDivision();
}
