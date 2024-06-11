package edu.badpals.repositorio;

import edu.badpals.dominio.Farmer;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FarmerRepo implements PanacheRepositoryBase<Farmer, Long>{
    
}
