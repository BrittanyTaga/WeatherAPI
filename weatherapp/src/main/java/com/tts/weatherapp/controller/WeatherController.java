package com.tts.weatherapp.controller;

import com.tts.weatherapp.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.tts.weatherapp.domain.Request;
import com.tts.weatherapp.domain.Response;



@Controller
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/")
    public String getIndex(Model model){ //Model is for view controller for front end
        model.addAttribute("request", new Request()); //first one for data, second one for front end
        return "index";
    }

    @PostMapping("/") //indicating what postmapping is being submitted
    public String postIndex(Request request, Model model){
        Response data = weatherService.getForecast(request.getZipCode());
        model.addAttribute("data", data);
        return "index";
    }
}
