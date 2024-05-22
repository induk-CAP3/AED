package com.example.aed.controller;

import com.example.aed.domain.EmerData;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EmerApiController {

    private static final Logger LOGGER = Logger.getLogger(EmerApiController.class.getName());

    @GetMapping("/emer")
    public String getEmerData() {
        List<EmerData> emerList = new ArrayList<>();

        try {
            String url = "http://openapi.seoul.go.kr:8088/4655744c43786f7239304f68495456/xml/TvEmgcHospitalInfo/1/67";
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            InputStream responseStream = connection.getInputStream();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(responseStream);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("row");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    EmerData emerData = new EmerData();
                    emerData.setBuildAddress(getTagValue("DUTYADDR", eElement));
                    emerData.setEnm(getTagValue("DUTYNAME", eElement));
                    emerData.setTelNumber(getTagValue("DUTYTEL3", eElement));
                    emerData.setEstate(getTagValue("DUTYERYN", eElement));
                    emerData.setLatitude(getTagValue("WGS84LAT", eElement));
                    emerData.setLongitude(getTagValue("WGS84LON", eElement));
                    emerList.add(emerData);
                }
            }

            JSONArray jsonArray = new JSONArray();
            for (EmerData emerData : emerList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("buildAddress", emerData.getBuildAddress());
                jsonObject.put("enm", emerData.getEnm());
                jsonObject.put("telNumber", emerData.getTelNumber());
                jsonObject.put("estate", emerData.getEstate());
                jsonObject.put("latitude", emerData.getLatitude());
                jsonObject.put("longitude", emerData.getLongitude());
                jsonArray.put(jsonObject);
            }

            return jsonArray.toString(); // Pretty print with an indentation of 4 spaces
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error while fetching and converting emergency data", e);
            return "{\"error\": \"Failed to fetch and convert data\"}";
        }
    }

    private String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = nlList.item(0);
        if (nValue == null) {
            return null;
        }
        return nValue.getNodeValue();
    }
}
