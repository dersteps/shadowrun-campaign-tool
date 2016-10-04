package de.zombielabs.campaign.core.util;

/**
 * The Tuple class is a generic tuple class, nothing less, nothing more.
 * Idea from here: http://stackoverflow.com/questions/2670982/using-pairs-or-2-tuples-in-java/2671052#2671052
 * @author steps
 */
public class Tuple<X, Y> {
    public final X x;
    public final Y y;
    public Tuple(final X x, final Y y) {
        this.x = x;
        this.y = y;
    }
}
