package rso.predictioncatalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rso.predictioncatalogue.entity.Prediction;

@Repository
public interface PredictionRepository extends JpaRepository<Prediction, Long>
{
    Prediction findByGameId(Long gameId);
}
