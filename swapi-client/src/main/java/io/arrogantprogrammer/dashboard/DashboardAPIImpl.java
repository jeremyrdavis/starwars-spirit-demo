package io.arrogantprogrammer.dashboard;

import io.arrogantprogrammer.dashboard.api.DashboardAPI;
import io.arrogantprogrammer.domain.StarWarsSpiritAssignmentRecord;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class DashboardAPIImpl implements DashboardAPI {

    static final Logger LOGGER = LoggerFactory.getLogger(DashboardAPIImpl.class);

    @Inject
    StarWarsSpiritAssignmentRepository  starWarsSpiritAssignmentRepository;

    @Override
    @Transactional
    public void addStarWarsSpiritAssignment(StarWarsSpiritAssignmentRecord starWarsSpiritAssignmentRecord) {
        starWarsSpiritAssignmentRepository.persist(new StarWarsSpiritAssignment(starWarsSpiritAssignmentRecord.name(), starWarsSpiritAssignmentRecord.spiritUrl()));
    }

    @Override
    public List<StarWarsSpiritAssignmentRecord> allStarWarsSpiritAssignments() {

        return starWarsSpiritAssignmentRepository.streamAll().map(s -> new StarWarsSpiritAssignmentRecord(s.getName(), s.getCharacterUrl())).collect(Collectors.toList());
    }

    @Override
    public String mostPopularSpiritCharacter() {
        return starWarsSpiritAssignmentRepository.mostPopularSpiritCharacter();
    }

}
