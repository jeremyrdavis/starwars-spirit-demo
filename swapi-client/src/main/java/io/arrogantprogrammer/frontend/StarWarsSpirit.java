package io.arrogantprogrammer.frontend;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.net.URI;
import java.util.Objects;

@Entity
public class StarWarsSpirit extends PanacheEntity {

    String name;

    URI characterUrl;

    protected StarWarsSpirit() {
    }

    protected StarWarsSpirit(String name, URI characterUrl) {
        this.name = name;
        this.characterUrl = characterUrl;
    }

    @Override
    public String toString() {
        return "StarWarsSpirit{" +
                "name='" + name + '\'' +
                ", characterUrl=" + characterUrl +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StarWarsSpirit that = (StarWarsSpirit) o;

        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(characterUrl, that.characterUrl);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (characterUrl != null ? characterUrl.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public URI getCharacterUrl() {
        return characterUrl;
    }
}
