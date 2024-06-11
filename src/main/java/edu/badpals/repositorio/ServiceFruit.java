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
        Optional<Farmer> posifarmero = Optional.ofNullable(farmerRepo.find("name = ?1", fruit.getFarmer().getName()).firstResult());
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

    public void remove(String nombre){
        Optional<Fruit> frutaEliminada = Optional.of(fruitRepo.find("name = ?1", nombre).firstResult());
        if (frutaEliminada.isPresent()){
            fruitRepo.delete(frutaEliminada.get());
        }
    }

    public Optional<Fruit> getFruit(String fruta){
        Optional<Fruit> frutas = fruitRepo.find("name = ?1", fruta).firstResultOptional();
        return frutas.isPresent() ? Optional.of(frutas.get()) : Optional.empty();
    }
}
