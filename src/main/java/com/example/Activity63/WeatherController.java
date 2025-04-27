package com.example.Activity63;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class WeatherController {

    @GetMapping("/")
    public String showForm() {
        return "weatherForm"; // Renders the HTML form
    }

    @PostMapping("/getWeather")
    public String getWeather(@RequestParam("latitude") String latitude,
                             @RequestParam("longitude") String longitude,
                             Model model) {
        // Step 1: Get grid points
        String gridUrl = "https://api.weather.gov/points/" + latitude + "," + longitude;
        RestTemplate restTemplate = new RestTemplate();
        var gridResponse = restTemplate.getForObject(gridUrl, Map.class);

        if (gridResponse == null || !gridResponse.containsKey("properties")) {
            model.addAttribute("error", "Invalid response from the weather service.");
            return "weatherForm";
        }

        var properties = (Map<String, Object>) gridResponse.get("properties");
        String office = (String) properties.get("gridId");
        String gridX = String.valueOf(properties.get("gridX"));
        String gridY = String.valueOf(properties.get("gridY"));

        // Step 2: Get forecast
        String forecastUrl = "https://api.weather.gov/gridpoints/" + office + "/" + gridX + "," + gridY + "/forecast";
        var forecastResponse = restTemplate.getForObject(forecastUrl, Map.class);

        if (forecastResponse == null || !forecastResponse.containsKey("properties")) {
            model.addAttribute("error", "Invalid response from the forecast service.");
            return "weatherForm";
        }

        var forecastProperties = (Map<String, Object>) forecastResponse.get("properties");
        model.addAttribute("forecast", forecastProperties.get("periods"));

        return "weatherResult"; // Renders the forecast results
    }
}
