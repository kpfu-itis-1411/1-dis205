package service;


import model.MasterListAndServices;

import repository.MasterListAndServicesRepository;

import java.util.List;

public class MasterListAndServicesService {

    private MasterListAndServicesRepository repository;

    public MasterListAndServicesService() {
        repository = new MasterListAndServicesRepository();
    }

    public MasterListAndServices save(MasterListAndServices masterListAndServices) {
        return repository.save(masterListAndServices);
    }

    public List<MasterListAndServices> findAll() {
        return repository.findAll();
    }

    public List<MasterListAndServices> findMastersByService(Long id) {
        return repository.findMastersByService(id);
    }

}
