package com.example.aed.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@RestController
public class ApiController{

    @GetMapping("/api/aed")
    public String callaedapihttp(){

        StringBuilder result = new StringBuilder();
        try{
            String urlstr = "http://apis.data.go.kr/B552657/AEDInfoInqireService/getAedLcinfoInqire?" +
                    "ServiceKey=rx1ry1iOvzMjA4aELaAJ3gLx%2Brp7wcf%2Fh5oWMUmWRKoJPu0XqGeRuBVKIGO2XogoHrOu8lxXHkMig00CtPxntg%3D%3D" +
                    "&type=xml" +
                    "&pageNo=1" +
                    "&numOfRows=1";
            URL url = new URL(urlstr);
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
            urlconnection.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));

            String line;
            result.append("<xmp>");
            while ((line = br.readLine()) != null){
                result.append(line + "\n");
            }
            urlconnection.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result+"</xmp>";
    }
    @GetMapping("/api/aed")
    public String callapihttp(){

        StringBuilder result = new StringBuilder();
        try{
            String urlstr = "http://apis.data.go.kr/B552657/AEDInfoInqireService/getAedLcinfoInqire?" +
                    "ServiceKey=rx1ry1iOvzMjA4aELaAJ3gLx%2Brp7wcf%2Fh5oWMUmWRKoJPu0XqGeRuBVKIGO2XogoHrOu8lxXHkMig00CtPxntg%3D%3D" +
                    "&type=xml" +
                    "&pageNo=1" +
                    "&numOfRows=1";
            URL url = new URL(urlstr);
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
            urlconnection.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));

            String line;
            result.append("<xmp>");
            while ((line = br.readLine()) != null){
                result.append(line + "\n");
            }
            urlconnection.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result+"</xmp>";
    }
}