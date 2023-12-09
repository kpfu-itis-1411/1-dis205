package service;


import model.Entry;

import repository.EntryRepository;

import java.util.List;

public class EntryService {

    private EntryRepository repository;

    public EntryService() {
        repository = new EntryRepository();
    }

    public void save(Entry entry) {
         repository.save(entry);
    }

    public List<Entry> findAll() {
        return repository.findAll();
    }

    public List<Entry> findById(Long id) {
        return repository.findById(id);
    }

    public List<Entry> findByIdMaster(Long id) {return repository.findByIdMaster(id);}

}
