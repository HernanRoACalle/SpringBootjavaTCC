//Daniel Alves - RM: 251376
//Hernan Rodrigo - RM:251169

package com.etec.fiatuno.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "TBL_USUARIO")
public class Usuario {

    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "TX_NOME")
    private String nome;
    @Column(name = "TX_SOBRENOME")
    private String sobrenome;
    @Column(name = "TX_EMAILUSUARIO")
    private String email;
    @Column(name = "NR_TELEFONEUSUARIO")
    private String telefone;
    @Column(name = "TP_USUARIO")
    private String tipoUsuario;
    @Column(name = "TX_DESCRICAO")
    private String descricao;
    @Column(name = "VALORMIN_ENTRADA")
    private Double minEntrada;
    @Column(name = "VALORMAX_ENTRADA")
    private Double maxEntrada;
}
