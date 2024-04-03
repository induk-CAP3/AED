package com.example.aed.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;

@RestController
public class AedApiController {
    // tag값의 정보를 가져오는 메소드
    private static String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if (nValue == null)
            return null;
        return nValue.getNodeValue();
    }
    public static void main(String[] args) {
        int page = 1;    // 페이지 초기값
        try {
            while (true) {
                // parsing할 url 지정(API 키 포함해서)
                String url = "http://openapi.seoul.go.kr:8088" +
                        "/4655744c43786f7239304f68495456" +
                        "/xml" +
                        "/tbEmgcAedInfo" +
                        "/1" +
                        "/1000";
                ;
                DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
                Document doc = dBuilder.parse(url);

                // root tag
                doc.getDocumentElement().normalize();
//                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

                // 파싱할 tag
                NodeList nList = doc.getElementsByTagName("row");

                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        System.out.println("######################");
                        System.out.println("설치 주소 : " + getTagValue("BUILDADDRESS", eElement));
                        System.out.println("설치 위치 : " + getTagValue("BUILDPLACE", eElement));
                        System.out.println("모델명 : " + getTagValue("MODEL", eElement));
                        System.out.println("관리자 번호 : " + getTagValue("MANAGERTEL", eElement));
                        System.out.println("데이터수 : " + temp);
                    }    // for end
                }break;
            }    // while end

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @GetMapping("/api/aed")
//    public String callaedapihttp(){
//
//        StringBuilder result = new StringBuilder();
//        try{
//            String urlstr = "http://openapi.seoul.go.kr:8088" +
//                    "/4655744c43786f7239304f68495456" +
//                    "/xml" +
//                    "/tbEmgcAedInfo" +
//                    "/1" +
//                    "/5";
//
//            URL url = new URL(urlstr);
//            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
//            urlconnection.setRequestMethod("GET");
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
//
//            String line;
//
//            while ((line = br.readLine()) != null){
//                result.append(line + "\n");
//            }
//            urlconnection.disconnect();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return result.toString();
//    }
}