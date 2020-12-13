package rso.predictioncatalogue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import rso.predictioncatalogue.annotation.ApiPageable;
import rso.predictioncatalogue.config.ConfigProperties;
import rso.predictioncatalogue.dto.PredictionDto;
import rso.predictioncatalogue.entity.Prediction;
import rso.predictioncatalogue.service.PredictionCatalogueService;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Basic operations", produces = "application/json", consumes = "application/json")
public class PredictionCatalogueController
{

    private final Logger log = LoggerFactory.getLogger(PredictionCatalogueController.class);

    private final ConfigProperties configProperties;

    private final PredictionCatalogueService predictionCatalogueService;

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
    public Prediction getPredictionForGame(@PathVariable("gameId") Long gameId){
        return predictionCatalogueService.getPredictionForGame(gameId);
    }

    @ApiPageable
    @PostMapping("/predictions")
    public Page<PredictionDto> getPredictions(@PageableDefault(size = 20)
                                           @SortDefault.SortDefaults({
                                              @SortDefault(sort = "timestamp", direction = Sort.Direction.ASC)
                                           }) @ApiIgnore Pageable pageable){
        return predictionCatalogueService.findAll(pageable);
    }

    @PostMapping("/predictions/save")
    public PredictionDto savePrediction(@RequestBody PredictionDto predictionDto) {
        return predictionCatalogueService.save(predictionDto);
    }

}
