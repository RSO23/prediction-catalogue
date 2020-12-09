package rso.predictioncatalogue.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rso.predictioncatalogue.entity.Prediction;
import rso.predictioncatalogue.repository.PredictionRepository;

@Service
@RequiredArgsConstructor
public class PredictionService
{

    private final PredictionRepository predictionRepository;

    public Prediction getPredictionForGame(String gameId){
        return predictionRepository.findByGameId(gameId);
    }

    public List<Prediction> findAll(){
        return (List<Prediction>) predictionRepository.findAll();
    }
}
