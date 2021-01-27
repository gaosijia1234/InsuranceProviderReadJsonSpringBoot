package com.example.demo.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProviderService {

    public List<JSONObject> getProviderInfo(Map<String, String> map, File fileName) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        List<JSONObject> lastNameList = new ArrayList<>();
        List<JSONObject> firstNameList = new ArrayList<>();

        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("com/example/springboot/files/providers.json"));

            System.out.println("reading file");

            for (Object object : jsonArray) {
                JSONObject provider = (JSONObject) object;

                JSONObject lastName = (JSONObject) provider.get("last_name");
                if(lastName.getString("last_name").equals("gao")){
                    lastNameList.add(lastName);
                    System.out.println(lastName);
                }

                JSONObject firstName = (JSONObject) provider.get("first_name");
                firstNameList.add(firstName);
                System.out.println(firstName);

            }
            List<JSONObject> result = new ArrayList<>();
            return lastNameList;

        } catch (IOException ioException) {
            throw ioException;
        } catch (ParseException parseException) {
            throw parseException;
        }


    }

}
