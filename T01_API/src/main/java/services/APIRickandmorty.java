/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.io.IOException;
import model.Rickandmorty;
import org.primefaces.shaded.json.JSONObject;

/**
 *
 * @author Usuario
 */
public class APIRickandmorty {

    public static JSONObject consumirID(Rickandmorty ric) throws Exception {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://rickandmortyapi.com/api/character/" + ric.getId())
                .header("id", "int")
                .header("name", "string")
                .header("type", "string")
                .header("dimension", "string")
                .header("residents", "array")
                .header("url", "string")
                .header("created", "string")
                .asString();
        JSONObject cadenaJson = new JSONObject(response.getBody());
//        JSONObject cadena = cadenaJson.getJSONObject("data");
        ric.setNombre(cadenaJson.getString("name"));
        ric.setEstatus(cadenaJson.getString("status"));
        ric.setEspecie(cadenaJson.getString("species"));
        ric.setImagen(cadenaJson.getString("image"));
        System.out.println("entre en la api " + ric.getNombre());
        return cadenaJson;
    }

        public static void main(String[] args) throws IOException, Exception {
        Rickandmorty personaje = new Rickandmorty();
        personaje.setId(1);
        JSONObject json = APIRickandmorty.consumirID(personaje);
        System.out.println("nombre :" + personaje.getNombre()+ ": " + personaje.getEstatus()+ ": "+personaje.getEspecie());
        

    }
}
