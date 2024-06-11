package edu.badpals.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fruit")
public class Fruit {

    @Id
        @Column(name = "id")
        private Long id = 0L;

        @Column(name = "name")
        private String name = "";

        @Column(name = "description")
        private String description = "";

        @ManyToOne
        @JoinColumn(name = "farmer_id")
        private Farmer farmer = null;

        public Fruit() {
        }

        public Fruit(String name, String description, Farmer farmer) {
            this.name = name;
            this.description = description;
            this.farmer = farmer;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Farmer getFarmer() {
            return farmer;
        }

        public void setFarmer(Farmer farmer) {
            this.farmer = farmer;
        }

        @Override
        public String toString() {
            return "Fruit [id=" + getId() + ", name=" + getName() + ", description=" + getDescription() + ", farmer=" + getFarmer() + "]";
        }

        
    
}
