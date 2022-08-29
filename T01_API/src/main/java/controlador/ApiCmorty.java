/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Data;
import model.Rickandmorty;
import services.APIRickandmorty;

/**
 *
 * @author Usuario
 */

@Named(value = "ApiCmorty")
@Data
@SessionScoped
public class ApiCmorty implements Serializable {

    Rickandmorty ric;


    public ApiCmorty() {
        ric = new Rickandmorty();
    }

    public void consumiendo(){
        try {
            APIRickandmorty.consumirID(ric);
        } catch (Exception e) {
            System.out.println("problemas en consumiendo " + e.getMessage());
        }

}
}