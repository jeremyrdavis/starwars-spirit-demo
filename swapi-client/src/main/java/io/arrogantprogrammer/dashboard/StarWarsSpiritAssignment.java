package io.arrogantprogrammer.dashboard;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class StarWarsSpiritAssignment extends PanacheEntity {

    String name;

    String characterUrl;

    ThumbsUpThumbsDown thumbsUpThumbsDown;

    protected StarWarsSpiritAssignment() {
    }

    protected StarWarsSpiritAssignment(String name, String characterUrl) {
        this.name = name;
        this.characterUrl = characterUrl;
    }

    public void thumbsUp() {
        this.thumbsUpThumbsDown = ThumbsUpThumbsDown.THUMBS_UP;
    }

    public void thumbsDown() {
        this.thumbsUpThumbsDown = ThumbsUpThumbsDown.THUMBS_DOWN;
    }

    public void thumbsNeutral() {
        this.thumbsUpThumbsDown = ThumbsUpThumbsDown.NEUTRAL;
    }

    @Override
    public String toString() {
        return "StarWarsSpiritAssignment{" +
                "name='" + name + '\'' +
                ", characterUrl='" + characterUrl + '\'' +
                ", thumbsUpThumbsDown=" + thumbsUpThumbsDown +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StarWarsSpiritAssignment that = (StarWarsSpiritAssignment) o;

        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(characterUrl, that.characterUrl)) return false;
        return thumbsUpThumbsDown == that.thumbsUpThumbsDown;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (characterUrl != null ? characterUrl.hashCode() : 0);
        result = 31 * result + (thumbsUpThumbsDown != null ? thumbsUpThumbsDown.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public String getCharacterUrl() {
        return characterUrl;
    }
}
