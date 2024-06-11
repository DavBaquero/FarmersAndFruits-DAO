package edu.badpals.repositorio;

import java.util.List;

import edu.badpals.dominio.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ServiceFruit {
    @Inject
    FarmerRepo farmerRepo;

    @Inject
    FruitRepo fruitRepo;

    public ServiceFruit() {
    }

    public List<Fruit> list(){
        List<Fruit> listaFrutas = fruitRepo.listAll();
        return listaFrutas;
    }
}
