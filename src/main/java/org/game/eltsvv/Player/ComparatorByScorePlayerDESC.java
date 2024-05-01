package org.game.eltsvv.Player;

import java.util.Comparator;

public class ComparatorByScorePlayerDESC implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        return Integer.compare(o2.getScore(), o1.getScore());
    }
}