package com.example.demo.controller;

import com.example.demo.service.ProviderService;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController("/stride/providers")
public class ProviderController {

    private ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping("/info")
    public List<JSONObject> getProviderInfo(Map<String, String> map, File fileName) throws IOException, ParseException {
        return providerService.getProviderInfo(map, fileName);
    }
}
