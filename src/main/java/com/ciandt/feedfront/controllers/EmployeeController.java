package com.ciandt.feedfront.controllers;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.exceptions.EmployeeNaoEncontradoException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.services.EmployeeService;
import com.ciandt.feedfront.services.EmployeeServiceImpl;
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
@RestController
@RequestMapping("/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @Operation(description = "Lista todos os Employees cadastrados")
    @GetMapping("/listar")
    public ResponseEntity<List<Employee>> listar() {
        return ResponseEntity.ok(employeeService.listar());
    }

    @Operation(description = "Retorna o dado pelo ID")
    @GetMapping("/buscarPorId")
    public ResponseEntity<Employee> buscar(@RequestParam Long id) throws BusinessException, EmployeeNaoEncontradoException {
        return ResponseEntity.ok(employeeService.buscar(id));
    }

    @Operation(description = "Salva o Employee no banco")
    @PostMapping("/salvar")
    public ResponseEntity<Employee> salvar(@RequestBody Employee employee) throws BusinessException {
        return ResponseEntity.ok(employeeService.salvar(employee));
    }

    @Operation(description = "Apaga o Employee do banco")
    @DeleteMapping("/delete")
    public ResponseEntity apagar(@RequestParam Long id) throws BusinessException, EmployeeNaoEncontradoException {
        employeeService.apagar(id);
        return ResponseEntity.ok("");
    }

    @Operation(description = "Editar o Employee")
    @PutMapping("/editar")
    public ResponseEntity<Employee> atualizar(@RequestBody Employee employee) throws BusinessException, EmployeeNaoEncontradoException {
        return ResponseEntity.ok(employeeService.atualizar(employee));
    }
}
