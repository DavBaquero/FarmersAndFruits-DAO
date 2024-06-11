package edu.badpals.repositorio;

import edu.badpals.dominio.Fruit;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FruitRepo implements PanacheRepositoryBase<Fruit, Long>{
    
}
