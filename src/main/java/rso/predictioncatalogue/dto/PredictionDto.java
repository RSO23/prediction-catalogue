package rso.predictioncatalogue.dto;

import lombok.Data;

@Data
public class PredictionDto
{

    private Long gameId;
    private String predictionResult;
    private double predictionCertainty;
    private long timestamp;
}
