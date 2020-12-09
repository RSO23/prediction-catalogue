package rso.predictioncatalogue.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PredictionDto
{

    private String gameId;
    private String prediction;
    private double predictionCertainty;

    public PredictionDto(String gameId){
        this.gameId = gameId;
    }
}
