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
}

