package com.example.aed.controller;

import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AedApiController {

    @GetMapping("/aed")
    public List<AedData> getAedData() {
        List<AedData> aedList = new ArrayList<>();

        try {
            String url = "http://openapi.seoul.go.kr:8088/4655744c43786f7239304f68495456/xml/tbEmgcAedInfo/1/1000";
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(url);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("row");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    AedData aedData = new AedData();
                    aedData.setBuildAddress(getTagValue("BUInpLDADDRESS", eElement));
                    aedData.setBuildPlace(getTagValue("BUILDPLACE", eElement));
                    aedData.setModel(getTagValue("MODEL", eElement));
                    aedData.setManagerTel(getTagValue("MANAGERTEL", eElement));
                    aedList.add(aedData);
                }
            }

//            System.out.println(aedList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return aedList;
    }

    private String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if (nValue == null)
            return null;
        return nValue.getNodeValue();
    }
}
