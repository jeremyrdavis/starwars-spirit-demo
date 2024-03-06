package io.arrogantprogrammer.dashboard.api;

import io.arrogantprogrammer.domain.StarWarsSpiritAssignmentRecord;

import java.util.List;

public interface DashboardAPI {

    void addStarWarsSpiritAssignment(StarWarsSpiritAssignmentRecord starWarsSpiritAssignmentRecord);

    List<StarWarsSpiritAssignmentRecord> allStarWarsSpiritAssignments();
}
