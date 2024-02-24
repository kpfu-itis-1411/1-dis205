package ru.kpfu.itis.service;
import ru.kpfu.itis.models.Cinema;
import ru.kpfu.itis.repository.CinemaRepository;
import ru.kpfu.itis.repository.Impl.CinemaRepositoryImpl;

import java.util.List;

public class CinemaService {
    private CinemaRepository cinemaRepository;

    public CinemaService(){
        cinemaRepository = new CinemaRepositoryImpl();
    }

    public List<Cinema> getAllCinema(){
        return cinemaRepository.findAll();
    }
    public Cinema getById(Integer id){
        List<Cinema> cinemas = getAllCinema();
        Cinema res = null;
        for(Cinema movie: cinemas){
            if(movie.getId() == id){
                res = movie;
                break;
            }
        }
        return res;
    }
    public void saveCinema(Cinema cinema) {
        cinemaRepository.save(cinema);
    }
}
