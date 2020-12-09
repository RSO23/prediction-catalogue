package rso.predictioncatalogue.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rso.predictioncatalogue.entity.Prediction;

@Repository
public interface PredictionRepository extends CrudRepository<Prediction, Long> {
    public Prediction findByGameId(String gameId);
}
