package com.example.model.service.impl;

import com.example.model.entity.employee.Division;
import com.example.model.entity.employee.EducationDegree;
import com.example.model.entity.employee.Employee;
import com.example.model.entity.employee.Position;
import com.example.model.repository.IDivisionRepository;
import com.example.model.repository.IEducationRepository;
import com.example.model.repository.IEmployeeRepository;
import com.example.model.repository.IPositionRepository;
import com.example.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;
    @Autowired
    IPositionRepository iPositionRepository;
    @Autowired
    IDivisionRepository iDivisionRepository;
    @Autowired
    IEducationRepository iEducationRepository;
    @Override
    public Page<Employee> findAllSearchName(Pageable pageable, String keyword) {
        return iEmployeeRepository.findAllByNameContaining(pageable, keyword);
    }

    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(Integer id) {
iEmployeeRepository.deleteById(id);
    }

    @Override
    public List<Position> listPosition() {
        return iPositionRepository.findAll();
    }

    @Override
    public List<EducationDegree> listEdu() {
        return iEducationRepository.findAll();
    }

    @Override
    public List<Division> listDivision() {
        return iDivisionRepository.findAll();
    }
}
