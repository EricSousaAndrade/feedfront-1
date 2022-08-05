package com.ciandt.feedfront.models;

import com.ciandt.feedfront.exceptions.ComprimentoInvalidoException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Employee {

    @Id
    private Long id;

    @Length(min = 3)
    @Column (nullable = false)
    private String nome;

    @Length(min = 3)
    @Column (nullable = false)
    private String sobrenome;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    private List<Feedback> feedbackFeitos;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    private List<Feedback> feedbackRecebidos;

    public Employee(String nome, String sobrenome, String email) throws ComprimentoInvalidoException {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Employee employee = (Employee) o;
        return id != null && Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
