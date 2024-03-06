package io.arrogantprogrammer.dashboard;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class StarWarsSpiritAssignmentRepository implements PanacheRepository<StarWarsSpiritAssignment> {

    @Transactional
    public void persist(StarWarsSpiritAssignment starWarsSpiritAssignment) {
        starWarsSpiritAssignment.persist();
    }

    public String mostPopularSpiritCharacter() {
        return StarWarsSpiritAssignment.find("SELECT characterUrl as characterUrl, COUNT(*) as urlCount FROM StarWarsSpiritAssignment GROUP BY characterUrl ORDER BY urlCount DESC").project(StarWarsSpiritAssignmentCharacterUrl.class).firstResult().characterUrl;
    }
}

