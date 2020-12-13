package rso.predictioncatalogue.mapper;

import rso.predictioncatalogue.dto.PredictionDto;
import rso.predictioncatalogue.entity.Prediction;

public class PredictionMapper
{
    public static Prediction mapToEntity(PredictionDto predictionDto) {
        Prediction prediction = new Prediction();
        prediction.setGameId(predictionDto.getGameId());
        prediction.setPredictionCertainty(predictionDto.getPredictionCertainty());
        prediction.setPredictionResult(predictionDto.getPredictionResult());
        prediction.setTimestamp(predictionDto.getTimestamp());
        return prediction;
    }

    public static PredictionDto mapToDto(Prediction prediction) {
        PredictionDto predictionDto = new PredictionDto();
        predictionDto.setGameId(prediction.getGameId());
        predictionDto.setPredictionCertainty(prediction.getPredictionCertainty());
        predictionDto.setPredictionResult(prediction.getPredictionResult());
        predictionDto.setTimestamp(prediction.getTimestamp());
        return predictionDto;
    }
}
