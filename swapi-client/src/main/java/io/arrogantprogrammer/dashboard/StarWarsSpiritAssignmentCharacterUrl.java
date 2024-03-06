package io.arrogantprogrammer.dashboard;

/**
 * Used as a query object only
 */
class StarWarsSpiritAssignmentCharacterUrl {

    public String characterUrl;

    public Long urlCount;

    public StarWarsSpiritAssignmentCharacterUrl(String characterUrl, Long urlCount) {
        System.out.println("constructor with %s and %s".formatted(characterUrl, urlCount));
        this.characterUrl = characterUrl;
        this.urlCount = urlCount;
    }

}
