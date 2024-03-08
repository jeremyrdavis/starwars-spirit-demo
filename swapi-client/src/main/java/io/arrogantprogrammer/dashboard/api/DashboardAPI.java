package io.arrogantprogrammer.dashboard.api;

import io.arrogantprogrammer.domain.StarWarsSpiritAssignmentRecord;
import io.arrogantprogrammer.domain.VoteThumbsUpOrDown;

import java.net.URI;
import java.util.List;

public interface DashboardAPI {

    void addStarWarsSpiritAssignment(StarWarsSpiritAssignmentRecord starWarsSpiritAssignmentRecord);

    List<StarWarsSpiritAssignmentRecord> allStarWarsSpiritAssignments();

    String mostPopularSpiritCharacter();

    void thumbsUpThumbsDown(VoteThumbsUpOrDown voteThumbsUpOrDown);
}
