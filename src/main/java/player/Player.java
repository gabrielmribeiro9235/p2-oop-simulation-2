package player;

import java.util.*;

public class Player implements Comparable<Player> {
    private final String userName;
    private final List<Integer> gameScores;

    public Player(String userName) {
        this.userName = userName;
        gameScores = new ArrayList<>();
    }

    public void addScore(int score) {
        gameScores.add(score);
    }

    private int biggestGameScore(List<Integer> list) {
        return list.stream().max(Integer::compare).orElse(0);
    }

    @Override
    public int compareTo(Player out) {
        Objects.requireNonNull(out, "The player can not be null.");

        Set<Integer> outScores = new HashSet<>(out.gameScores);
        Set<Integer> inScores = new HashSet<>(this.gameScores);

        while (
                biggestGameScore(outScores.stream().toList()) == biggestGameScore(inScores.stream().toList())
                && !outScores.isEmpty()
                && !inScores.isEmpty()
        ) {
            Integer biggestOut = biggestGameScore(outScores.stream().toList());
            Integer biggestIn = biggestGameScore(inScores.stream().toList());

            outScores.remove(biggestOut);
            inScores.remove(biggestIn);
        }

        if (outScores.isEmpty() && inScores.isEmpty()) {
            return this.userName.compareTo(out.userName);
        }

        return Integer.compare(biggestGameScore(outScores.stream().toList()), biggestGameScore(inScores.stream().toList()));
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(userName, player.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userName);
    }

    @Override
    public String toString() {
        return String.format("Username = %s | Max score = %d", getUserName(), biggestGameScore(gameScores));
    }
}
