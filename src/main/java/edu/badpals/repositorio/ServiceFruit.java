package edu.badpals.repositorio;

import java.util.List;
import java.util.Optional;

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

    public void add(Fruit fruit){
        Optional<Farmer> posifarmero = Optional.of(farmerRepo.find("name = ?1", fruit.getFarmer().getName()).firstResult());
        Fruit fruta = null;
        Farmer farmero = null;
        if(posifarmero.isPresent()){
            farmero = posifarmero.get();
        } else{
            Farmer nFarmero = new Farmer(fruit.getFarmer().getName(), fruit.getFarmer().getLocation());
            farmero = nFarmero;
            farmerRepo.persist(farmero);
        }

        fruta = new Fruit(fruit.getName(),fruit.getDescription(),farmero);
        fruitRepo.persist(fruta);
    }
}
