package edu.badpals.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "farmer")
public class Farmer {
    
    @Id
        @Column(name = "id")
        private Long id = 0L;

        @Column(name = "name")
        private String name = "";

        @Column(name = "location")
        private String location = "";

        public Farmer() {
        }

        public Farmer(String name, String location) {
            this.name = name;
            this.location = location;
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

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        @Override
        public String toString() {
            return "Farmer [id=" + getId() + ", name=" + getName() + ", location=" + getLocation() + "]";
        }

        
}
