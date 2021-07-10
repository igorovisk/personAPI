package one.digitalinnovation.personapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Nao pode ter valor nulo
    private String firstName;

    @Column(nullable = false) // Nao pode ter valor nulo
    private String lastName;

    @Column(nullable = false, unique = true) // Nao pode ter valor nulo E É UM VALOR UNICO
    private String cpf;

    @Column(nullable = true) // Nao pode ter valor nulo
    private LocalDate birthDate;

    @Column(nullable = false) // Nao pode ter valor nulo
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})  //Cascade faz o que????
    private List<Phone> phones = new ArrayList<>();


}
