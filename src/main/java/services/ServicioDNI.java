/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class ServicioDNI {

    private static final String API_URL = "https://dniruc.apisperu.com/api/v1/dni/";
    private static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImdpdWxpYW5hZnJhbmNpc2NhcGFyZWRlc0BnbWFpbC5jb20ifQ.rX-ZGJWC9xo0TQWOYdJXU5VHMhZb6b9J2dK9l6-k4Ak";

    public static String buscar(String text) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(API_URL + text + "?token=" + TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static void buscarDNI(String text) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(API_URL + text + "?token=" + TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        JsonObject jsonObject = JsonParser.parseString​(response.body().string()).getAsJsonObject();
        if (jsonObject.isJsonObject()) {
            JsonObject rootobj=jsonObject.getAsJsonObject();
            String DNI=rootobj.get("dni").toString();
            String name=rootobj.get("nombres").toString();
            String lastNamePaternal=rootobj.get("apellidoPaterno").toString();
            String lastNameMaternal=rootobj.get("apellidoMaterno").toString();
            String codeVerification=rootobj.get("codVerifica").toString();
            String codeVerificationLetter=rootobj.get("codVerificaLetra").toString();
            System.out.println("DNI : "+DNI + "name : " + name + "apellidoPaterno : "+ lastNamePaternal + "apellidoMaterno : "+ lastNameMaternal + "codVerifica : " + codeVerification + "codVerificaLetra : "+ codeVerificationLetter) ;
        }
    }

    public static void main(String[] args) throws Exception {
        String texto = "72717476";
        String resultado = buscar(texto);
        buscarDNI(texto);
        System.out.println("resultado" + resultado);
    }
}
