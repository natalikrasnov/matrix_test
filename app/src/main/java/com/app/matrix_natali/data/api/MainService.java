package com.app.matrix_natali.data.api;

import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MainService {

    public Reader getJsonSOFromUrl(String urlS){
        try {
            URL obj = new URL(urlS);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            if (con.getResponseCode() == 200) {
                return new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8);
            }
            return null;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (ProtocolException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
