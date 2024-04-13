package com.example.aed.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

@RestController
@RequestMapping("/api")
public class EmerApiController {

    @GetMapping("/emer")
    public List<EmerData> getEmerData() {
        List<EmerData> emerList = new ArrayList<>();

        try {
            String url = "http://openapi.seoul.go.kr:8088/4655744c43786f7239304f68495456/xml/TvEmgcHospitalInfo/1/69";
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(url);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("row");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    EmerData emerData = new EmerData();
                    emerData.setBuildAddress(getTagValue("DUTYADDR", eElement));
                    emerData.setBuildPlace(getTagValue("DUTYNAME", eElement));
//                    emerData.setModel(getTagValue("MODEL", eElement));
                    emerData.setManagerTel(getTagValue("DUTYTEL3", eElement));
                    emerList.add(emerData);
                }
            }
            System.out.println(emerList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emerList;
    }

    private String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if (nValue == null)
            return null;
        return nValue.getNodeValue();
    }
}
