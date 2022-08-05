package com.ciandt.feedfront.services;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.exceptions.EmployeeNaoEncontradoException;
import com.ciandt.feedfront.models.Feedback;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FeedbackService {
    List<Feedback> listar();

    Feedback buscar(Long id) throws BusinessException, EmployeeNaoEncontradoException;

    Feedback salvar(Feedback e) throws BusinessException, IllegalArgumentException, EmployeeNaoEncontradoException;
}
