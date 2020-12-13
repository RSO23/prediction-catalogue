package rso.predictioncatalogue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "predictions")
public class Prediction
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long predictionId;

    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "prediction_result")
    private String predictionResult;

    @Column(name = "prediction_certainty")
    private double predictionCertainty;

    @Column(name = "timestamp")
    private long timestamp;
}

