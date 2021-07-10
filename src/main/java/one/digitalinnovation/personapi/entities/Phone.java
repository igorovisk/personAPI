package one.digitalinnovation.personapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.*;

@Entity // A CLASSE É UA ENTIDADE DO BANCO DE DADOS
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class Phone {
    @Id //id no banco de dados, porém se tiver mtos delegamos ao banco de dados generated value
    @GeneratedValue(strategy = GenerationType.IDENTITY) //toda vez que recebe um dado ele é incremental (????)
    private Long id;

    @Enumerated(EnumType.STRING) //Vai ser so do tipo string
    @Column(nullable = false) // Nao pode ter valor nulo
    private PhoneType type;

    @Column(nullable = false) // Nao pode ter valor nulo
    private String number;

}
