package rso.predictioncatalogue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rso.predictioncatalogue.entity.Prediction;

@Repository
public interface PredictionRepository extends JpaRepository<Prediction, Long>
{
    Prediction findByGameId(Long gameId);

    List<Prediction> findAllByUserId(Long userId);

    List<Prediction> findAllByGameIdIn(List<Long> gameId);
}
