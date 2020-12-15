package rso.predictioncatalogue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rso.predictioncatalogue.dto.PredictionDto;
import rso.predictioncatalogue.entity.Prediction;
import rso.predictioncatalogue.mapper.PredictionMapper;
import rso.predictioncatalogue.repository.PredictionRepository;

@Service
@RequiredArgsConstructor
public class PredictionCatalogueService
{

    private final PredictionRepository predictionRepository;

    public Prediction getPredictionForGame(Long gameId){
        return predictionRepository.findByGameId(gameId);
    }

    public Page<PredictionDto> findAll(Pageable pageable){
        return predictionRepository.findAll(pageable).map(PredictionMapper::mapToDto);
    }

    public List<PredictionDto> findAllByUserId(Long userId) {
        return predictionRepository.findAllByUserId(userId).stream()
                .map(PredictionMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public PredictionDto save(PredictionDto predictionDto) {
        Prediction prediction = PredictionMapper.mapToEntity(predictionDto);
        return PredictionMapper.mapToDto(predictionRepository.save(prediction));
    }

    public List<PredictionDto> findAllByGameIds(List<Long> gameIds) {
        return predictionRepository.findAllByGameIdIn(gameIds).stream()
                .map(PredictionMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
