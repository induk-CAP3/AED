package com.example.aed.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.w3c.dom.Element;

@RestController
public class EmerApiController {
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
                        "/TvEmgcHospitalInfo" +
                        "/1" +
                        "/69";
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
                        System.out.println("이름 : " + getTagValue("DUTYNAME", eElement));
                        System.out.println("주소 : " + getTagValue("DUTYADDR", eElement));
                        System.out.println("번호 : " + getTagValue("DUTYTEL3", eElement));
                        System.out.println("데이터수 : " + temp);
                    }    // for end
                }    // if end

                page += 1;
//                System.out.println("page number : " + page);
                if (page > 12) {
                    break;
                }
            }    // while end

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    @GetMapping("/api/emer")
//    public String callemerapihttp() {
//        StringBuilder result = new StringBuilder();
//        try {
//            String urlstr = "http://openapi.seoul.go.kr:8088" +
//                    "/4655744c43786f7239304f68495456" +
//                    "/xml" +
//                    "/TvEmgcHospitalInfo" +
//                    "/1" +
//                    "/7";
//
//            URL url = new URL(urlstr);
//            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
//            urlconnection.setRequestMethod("GET");
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
//
//            String line;
//            while ((line = br.readLine()) != null) {
//                result.append(line + "\n");
//            }
//            urlconnection.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////        System.out.println(result);
//        return result + "\n";
//    }
}