/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import model.Rickandmorty;
import org.primefaces.shaded.json.JSONObject;

/**
 *
 * @author Usuario
 */
public class APIRickandmorty {

    public static JSONObject consumirID(Rickandmorty ric) throws Exception {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://rickandmortyapi.com/api/character/" + ric.getNombre())
                .header("id", "integer")
                .header("name", "String")
                .header("status", "String")
                .header("species", "String")
                .asString();
        JSONObject cadenaJson = new JSONObject(response.getBody());
//        JSONObject cadena = cadenaJson.getJSONObject("data");
        ric.setNombre(cadenaJson.getString("name")); 
        ric.setEstatus(cadenaJson.getString("status"));
         ric.setEspecie(cadenaJson.getString("species"));
         ric.setImagen(cadenaJson.getString("imagen"));
         System.out.println("entre en la api "+ ric.getNombre());
        return cadenaJson;
    }
    
}
