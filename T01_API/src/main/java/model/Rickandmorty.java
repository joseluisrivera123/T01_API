/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import lombok.Data;

/**
 *
 * @author Usuario
 */
@Data
public class Rickandmorty {
    Integer id;
    String nombre;
    String estatus;
    String especie;
    String imagen;
}
