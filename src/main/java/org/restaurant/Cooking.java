package org.restaurant;

public class Cooking {

    public Cook makeCook(MenuItem menuItem) {
        return new Cook(menuItem);
    }
}
