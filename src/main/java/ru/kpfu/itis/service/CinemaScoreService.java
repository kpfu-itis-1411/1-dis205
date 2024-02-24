package ru.kpfu.itis.service;


import ru.kpfu.itis.models.CinemaScore;
import ru.kpfu.itis.repository.CinemaScoreRepository;
import ru.kpfu.itis.repository.Impl.CinemaScoreRepositoryImpl;

import java.util.List;

public class CinemaScoreService {
    private CinemaScoreRepository cinemaScoreRepository;
    public CinemaScoreService(){
        cinemaScoreRepository = new CinemaScoreRepositoryImpl();
    }

    public List<CinemaScore> getAllCinema(){
        return cinemaScoreRepository.findAll();
    }
    public void saveCinema(CinemaScore score) {
        cinemaScoreRepository.save(score);
    }
}
