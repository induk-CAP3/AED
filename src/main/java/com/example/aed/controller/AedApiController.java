package com.example.aed.controller;

import com.example.aed.entity.AedEntity;
import com.example.aed.repository.AedRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final AedRepository aedRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public AedApiController(AedRepository aedRepository, ObjectMapper objectMapper) {
        this.aedRepository = aedRepository;
        this.objectMapper = objectMapper;
    }

    public List<AedEntity> fetchAedAndSave() {
        List<AedEntity> aedEntities = new ArrayList<>();

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
                    AedEntity aedEntity = new AedEntity();
                    aedEntity.setBuildAddress(getTagValue("BUILDADDRESS", eElement));
                    aedEntity.setBuildPlace(getTagValue("BUILDPLACE", eElement));
                    aedEntity.setModel(getTagValue("MODEL", eElement));
                    aedEntity.setManagerTel(getTagValue("MANAGERTEL", eElement));
                    aedEntity.setLatitude(getTagValue("WGS84LAT", eElement));
                    aedEntity.setLongitude(getTagValue("WGS84LON", eElement));
                    aedEntity.setZip1(getTagValue("ZIPCODE1", eElement));
                    aedEntity.setZip2(getTagValue("ZIPCODE2", eElement));
                    aedEntity.setManager(getTagValue("MANAGER", eElement));
                    aedEntity.setClienttel(getTagValue("CLERKTEL", eElement));
                    aedEntity.setCol(getTagValue("MFG", eElement));
                    aedEntity.setOrg(getTagValue("ORG", eElement));
                    aedEntities.add(aedEntity);
                }
            }

            // Save in batches of 1000
            if (aedEntities.size() == 1000) {
                aedRepository.saveAll(aedEntities);
                aedEntities.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aedEntities;
    }

    private String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = nlList.item(0);
        if (nValue == null)
            return null;
        return nValue.getNodeValue();
    }

    @GetMapping("/aed")
    public String getAllAeds() {
        try {
            List<AedEntity> aeds = aedRepository.findAll();
            return objectMapper.writeValueAsString(aeds); // Convert to JSON string
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\": \"Failed to convert data to JSON\"}";
        }
    }
}
