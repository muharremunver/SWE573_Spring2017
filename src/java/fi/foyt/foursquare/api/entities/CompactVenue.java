/*
 * FoursquareAPI - Foursquare API for Java
 * Copyright (C) 2008 - 2011 Antti Leppä / Foyt
 * http://www.foyt.fi
 * Copyright (C) 2014 - Blake Dy / Wallaby
 * http://walla.by
 * 
 * License: 
 * 
 * Licensed under GNU Lesser General Public License Version 3 or later (the "LGPL")
 * http://www.gnu.org/licenses/lgpl.html
 */
package fi.foyt.foursquare.api.entities;

import fi.foyt.foursquare.api.FoursquareEntity;
import fi.foyt.foursquare.api.entities.venue.*;

import java.util.Arrays;

/**
 * Class representing CompactVenue entity
 *
 * @see
 * <a href="https://developer.foursquare.com/docs/responses/venue.html" target="_blank">https://developer.foursquare.com/docs/responses/venue.html</a>
 *
 * @author Antti Leppä / Blake Dy
 */
public class CompactVenue implements FoursquareEntity {

    private static final long serialVersionUID = -7714811839778109046L;

    /**
     * Returns id of the venue
     *
     * @return id of the venue
     */
    public String getId() {
        return id;
    }

    /**
     * Returns name of the venue
     *
     * @return name of the venue
     */
    public String getName() {
        return name;
    }

    /**
     * Returns contact information for the venue
     *
     * @return contact information for the venue
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * Returns venue's contact information
     *
     * @return venue's contact information
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Returns array of venue's categories
     *
     * @return array of venue's categories
     */
    public Category[] getCategories() {
        return categories;
    }

    /**
     * Returns true if this venue has been verified
     *
     * @return true if this venue has been verified
     */
    public Boolean getVerified() {
        return verified;
    }

    /**
     * Returns statistical information about this venue
     *
     * @return statistical information about this venue
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * Returns url for this venue
     *
     * @return url for this venue
     */
    public String getUrl() {
        return url;
    }

    /**
     * Returns the hours during the week that the venue is open along with any
     * named hours segments in a human-readable format.
     *
     * @return the hours during the week that the venue is open along with any
     * named hours segments in a human-readable format.
     */
    public Hours getHours() {
        return hours;
    }

    /**
     * Returns the hours during the week when people usually go to the venue.
     *
     * @return the hours during the week when people usually go to the venue.
     */
    public Hours getPopular() {
        return popular;
    }

    /**
     * Returns an object containing url and mobileUrl that display the menu
     * information for this venue.
     *
     * @return an object containing url and mobileUrl that display the menu
     * information for this venue.
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * Returns an object containing the price tier from 1 (least pricey) - 4
     * (most pricey) and a message describing the price tier.
     *
     * @return an object containing the price tier from 1 (least pricey) - 4
     * (most pricey) and a message describing the price tier.
     */
    public Price getPrice() {
        return price;
    }

    /**
     * Returns a numerical rating of the venue (0 through 10).
     *
     * @return a numerical rating of the venue (0 through 10).
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * Returns array of specials at this venue
     *
     * @return array of specials at this venue
     */
    public CompleteSpecial[] getSpecials() {
        return specials;
    }

    public Boolean isClosed() {
        return isClosed;
    }

    /**
     * Returns information about who is here now
     *
     * @return information about who is here now
     */
    public HereNow getHereNow() {
        return hereNow;
    }

    /**
     * Returns todo group for this compact venue
     *
     * @return todos group for this compact venue
     */
    public TodoGroup getTodos() {
        return todos;
    }
    protected String id;
    protected String name;
    protected Contact contact;
    protected Location location;
    protected Category[] categories;
    protected Boolean verified;
    protected Stats stats;
    protected String url;
    protected Hours hours;
    protected Hours popular;
    protected Menu menu;
    protected Price price;
    protected Integer rating;
    protected CompleteSpecial[] specials;
    protected HereNow hereNow;
    protected Boolean isClosed = false;
    protected TodoGroup todos;

    // TODO
    protected String page;

    @Override
    public String toString() {
        return "CompactVenue{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ",\ncontact=" + contact
                + ",\nlocation=" + location
                + ",\ncategories=" + Arrays.toString(categories)
                + ",\ntodo=" + todos
                + ",\nverified=" + verified
                + ", stats=" + stats
                + ",\nurl='" + url + '\''
                + ", hours=" + hours
                + ",\npopular=" + popular
                + ", menu=" + menu
                + ",\nprice=" + price
                + ",\nrating=" + rating
                + ",\nspecials=" + Arrays.deepToString(specials)
                + ",\nhereNow=" + hereNow
                + ",\npage='" + page + '\''
                + ",\nisClosed='" + isClosed + '\''
                + '}';
    }
}
