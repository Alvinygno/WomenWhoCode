package com.example.womenwhocode.womenwhocode.models;

import com.example.womenwhocode.womenwhocode.utils.Utilities;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by zassmin on 10/16/15.
 */
@ParseClassName("Post")
public class Post extends ParseObject {
    public static String DESCRIPTION_KEY = "description";
    public static String NETWORK_KEY = "network";
    public static String EVENT_KEY = "event";
    public static String FEATURE_KEY = "feature";
    public static String AWESOME_COUNT_KEY = "awesome_count";
    public static String USER_KEY = "user";

    public String getDescription() {
        return this.get(DESCRIPTION_KEY).toString();
    }

    public void setDescription(String description) {
        put(DESCRIPTION_KEY, description);
    }

    public Network getNetwork() {
        return (Network) getParseObject(NETWORK_KEY);
    }

    public void setNetwork(Network network) {
        put(NETWORK_KEY, network);
    }

    public Event getEvent() {
        Event event = null;
        try {
            event = getParseObject(EVENT_KEY).fetchIfNeeded();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException nullError) {
            nullError.printStackTrace();
        }
        return event;
    }

    public void setEvent(Event event) {
        put(EVENT_KEY, event);
    }

    public Feature getFeature() {
        Feature feature = null;
        try {
            feature = getParseObject(FEATURE_KEY).fetchIfNeeded();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException nullError) {
            nullError.printStackTrace();
        }
        return feature;
    }

    public void setFeature(Feature feature) {
        put(FEATURE_KEY, feature);
    }

    public String getFeatureImageUrl() {
        Feature feature = null;
        try {
            feature = this.getFeature().fetchIfNeeded();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException nullError) {
            nullError.printStackTrace();
        }
        return feature.getImageUrl();
    }

    public String getFeatureTitle() {
        Feature feature = null;
        try {
            feature = this.getFeature().fetchIfNeeded();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException nullError) {
            nullError.printStackTrace();
        }
        return feature.getTitle();
    }

    public ParseUser getUser() {
        ParseUser user = null;
        try {
            user = getParseObject(USER_KEY).fetchIfNeeded();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException nullError) {
            nullError.printStackTrace();
        }
        return user;
    }

    public void setUser(ParseUser user) {
        put(USER_KEY, user);
    }

    public int getAwesomeCount() {
        return this.getInt(AWESOME_COUNT_KEY);
    }

    // awesomeCount is for our stretch goals
    public void setAwesomeCount(int awesomeCount) {
        put(AWESOME_COUNT_KEY, awesomeCount);
    }

    public String getPostDateTime() {
        return Utilities.getRelativeTimeAgo(this.getCreatedAt().toString());
    }


}