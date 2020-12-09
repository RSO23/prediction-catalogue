package rso.predictioncatalogue.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import rso.predictioncatalogue.config.ConfigProperties;
import rso.predictioncatalogue.entity.Prediction;
import rso.predictioncatalogue.service.PredictionService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Basic operations", produces = "application/json", consumes = "application/json")
public class PredictionCatalogueController
{

    private final Logger log = LoggerFactory.getLogger(PredictionCatalogueController.class);


    private final ConfigProperties configProperties;

    private final PredictionService predictionService;

    @GetMapping("/ping")
    public String ping(){
        log.info("Ping!");
        return "Pong!";
    }

    @GetMapping("/config")
    public String testConfig() {
        return configProperties.getTestConfig();
    }

    @GetMapping("/predictions/{gameId}")
    public Prediction getPredictionForGame(@PathVariable("gameId") String gameId){
        return predictionService.getPredictionForGame(gameId);
    }

    @GetMapping("/predictions")
    public List<Prediction> getPredictions(){
        return predictionService.findAll();
    }

}
