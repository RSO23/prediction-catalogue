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
        prediction.setUserId(predictionDto.getUserId());
        prediction.setTeam(predictionDto.getTeam());
        prediction.setWinner(predictionDto.getWinner());
        return prediction;
    }

    public static PredictionDto mapToDto(Prediction prediction) {
        PredictionDto predictionDto = new PredictionDto();
        predictionDto.setGameId(prediction.getGameId());
        predictionDto.setPredictionCertainty(prediction.getPredictionCertainty());
        predictionDto.setPredictionResult(prediction.getPredictionResult());
        predictionDto.setTimestamp(prediction.getTimestamp());
        predictionDto.setUserId(prediction.getUserId());
        predictionDto.setTeam(prediction.getTeam());
        predictionDto.setWinner(prediction.getWinner());
        return predictionDto;
    }
}
