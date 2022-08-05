package com.ciandt.feedfront.services;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.exceptions.EmployeeNaoEncontradoException;
import com.ciandt.feedfront.exceptions.EntidadeNaoEncontradaException;
import com.ciandt.feedfront.models.Feedback;
import com.ciandt.feedfront.repositories.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedBackRepository;

    private final EmployeeServiceImpl employeeService;

    @Override
    public List<Feedback> listar() {
        return feedBackRepository.findAll();
    }

    @Override
    public Feedback buscar(Long id) throws BusinessException, EmployeeNaoEncontradoException {
        return feedBackRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("não foi possível encontrar o feedback"));
    }

    @Override
    public Feedback salvar(Feedback feedback) throws BusinessException, IllegalArgumentException, EmployeeNaoEncontradoException {
        if(feedback == null){
            throw new IllegalArgumentException("feedback inválido");
        }else if(feedback.getProprietario() == null){
            throw new IllegalArgumentException("employee inválido");
        }
        employeeService.buscar(feedback.getProprietario().getId());
        if(feedback.getAutor() != null){
            employeeService.buscar(feedback.getAutor().getId());
        }
        return feedBackRepository.save(feedback);
    }
}
