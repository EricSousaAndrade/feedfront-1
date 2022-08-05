package com.ciandt.feedfront.controllers;


import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.exceptions.EmployeeNaoEncontradoException;
import com.ciandt.feedfront.models.Feedback;
import com.ciandt.feedfront.services.FeedbackService;
import com.ciandt.feedfront.services.FeedbackServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiResponses(
        value = {
                @ApiResponse(responseCode = "200", description = "Sucesso na requisição"),
                @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
        }
)
@RequestMapping("/v1/feedbacks")
@RequiredArgsConstructor
@RestController
public class FeedbackController {

    private final FeedbackServiceImpl feedbackService;

    @Operation(description = "Este retorna todos os dados enviados pelos usuários no banco de dados.")
    @GetMapping("/listar")
    public ResponseEntity<List<Feedback>> listar() {
        return ResponseEntity.ok(feedbackService.listar());
    }

    @Operation(description = "Retorna o feedback pelo id")
    @GetMapping("/buscarPorId")
    public ResponseEntity<Feedback> buscar(@RequestParam Long id) throws BusinessException, EmployeeNaoEncontradoException {
        return ResponseEntity.ok(feedbackService.buscar(id));
    }

    @Operation(description = "Salva um novo feedback")
    @GetMapping("/salvar")
    public ResponseEntity<Feedback> salvar(@RequestBody Feedback feedback) throws BusinessException, EmployeeNaoEncontradoException {
        return ResponseEntity.ok(feedbackService.salvar(feedback));
    }
}
