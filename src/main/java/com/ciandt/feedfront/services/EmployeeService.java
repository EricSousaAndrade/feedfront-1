package com.ciandt.feedfront.services;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.exceptions.EmployeeNaoEncontradoException;
import com.ciandt.feedfront.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> listar();

    Employee buscar(Long id) throws BusinessException, EmployeeNaoEncontradoException;

    Employee salvar(Employee e) throws BusinessException, IllegalArgumentException;

    Employee atualizar(Employee e) throws BusinessException, IllegalArgumentException, EmployeeNaoEncontradoException;

    void apagar(Long id) throws BusinessException, EmployeeNaoEncontradoException;
}
