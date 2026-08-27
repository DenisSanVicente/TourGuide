package com.openclassrooms.tourguide.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import gpsUtil.location.VisitedLocation;
import lombok.Getter;
import lombok.Setter;
import tripPricer.Provider;

@Getter
public class User {

    private final UUID userId;
    private final String userName;

    @Setter
    private String phoneNumber;

    @Setter
    private String emailAddress;

    @Setter
    private Date latestLocationTimestamp;

    private final List<VisitedLocation> visitedLocations =
            new CopyOnWriteArrayList<>();

    private final List<UserReward> userRewards =
            new CopyOnWriteArrayList<>();

    @Setter
    private UserPreferences userPreferences =
            new UserPreferences();

    @Setter
    private List<Provider> tripDeals =
            new ArrayList<>();

    public User(UUID userId,
                String userName,
                String phoneNumber,
                String emailAddress) {

        this.userId = userId;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public void addToVisitedLocations(VisitedLocation visitedLocation) {
        visitedLocations.add(visitedLocation);
    }

    public void clearVisitedLocations() {
        visitedLocations.clear();
    }

    public void addUserReward(UserReward userReward) {

        boolean alreadyRewarded = userRewards.stream()
                .anyMatch(reward ->
                        reward.attraction.attractionName.equals(
                                userReward.attraction.attractionName
                        )
                );

        if (!alreadyRewarded) {
            userRewards.add(userReward);
        }
    }

    public VisitedLocation getLastVisitedLocation() {
        return visitedLocations.get(visitedLocations.size() - 1);
    }
}