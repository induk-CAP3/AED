package com.example.aed.controller;

import com.example.aed.domain.AedData;
import com.example.aed.entity.AedEntity;
import com.example.aed.repository.AedRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AedApiController {
    private final AedRepository aedRepository;

    @Autowired
    public AedApiController(AedRepository aedRepository) {
        this.aedRepository = aedRepository;
    }

    public List<AedEntity> fetchAedAndSave() {
        List<AedEntity> aedEntities = new ArrayList<>();

        try {
            String url = "http://openapi.seoul.go.kr:8088/4655744c43786f7239304f68495456/xml/tbEmgcAedInfo/9001/9213";
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
            //1000개단위로 db 저장
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
        Node nValue = (Node) nlList.item(0);
        if (nValue == null)
            return null;
        return nValue.getNodeValue();
    }

    //aed테이블에서 데이터 받아 aeds에 저장
    @GetMapping("/aed")
    public List<AedEntity> getAllAeds() {
        List<AedEntity> aeds = aedRepository.findAll();
        return aeds;
    }
}
