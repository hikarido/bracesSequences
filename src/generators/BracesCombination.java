package generators;

import java.util.ArrayList;
import java.util.List;

/**
 * 1) Represents shit  about
 * n = 1 - ()
 * n = 2 - (())
 * n = 3 - (())()
 * ...
 * n = 4 - (()()())
 * 2) Maintains Open and close braces order
 * 3) Amount of braces always equals to 2*n
 */
class BracesCombination {
    private static final String openBrace = "(";
    private static final String closeBrace = ")";
    private final List<String> combination;

    public BracesCombination(BracesCombination braces) {
        combination = new ArrayList<>(braces.combination);
    }

    public BracesCombination(int n) {
        combination = new ArrayList<>(2 * n);
        for (int i = 0; i < n; i++) {
            combination.add(i, openBrace);
        }

        for (int i = n; i < 2 * n; i++) {
            combination.add(i, closeBrace);
        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (String s : combination) {
            b.append(s);
        }
        return b.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (other.getClass() != this.getClass()) {
            return false;
        }

        BracesCombination right = (BracesCombination) other;
        if (combination.equals(right.combination)) {
            return true;
        }

        return false;
    }

    public List<Pair<Integer, Integer>> searchOfAllDoors() {
        List<Pair<Integer, Integer>> doors = new ArrayList<>();
        for (int i = 0; i < combination.size() - 1; i++) {
            if (isDoor(combination, i, i + 1)) {
                doors.add(new SimplePair<>(i, i + 1));
            }
        }
        return doors;
    }

    private boolean isDoor(List<String> braces, int start, int finish) {
        if (braces.get(start).equals(openBrace) & braces.get(finish).equals(closeBrace)) {
            return true;
        }

        return false;
    }

    public BracesCombination moveDoor(Pair<Integer, Integer> door, boolean toLeft) {
        if (door.getFirst() == 0) {
            return this;
        }

        if (door.getSecond() == combination.size() - 1){
            return this;
        }

        BracesCombination newComb = new BracesCombination(this);
        String left = newComb.combination.get(door.getFirst());
        String right = newComb.combination.get(door.getSecond());
        if(toLeft){
            String tmp = newComb.combination.get(door.getFirst() - 1);
            newComb.combination.set(door.getFirst() - 1, left);
            newComb.combination.set(door.getFirst(), right);
            newComb.combination.set(door.getSecond(), tmp);
        }
        else{
            String tmp = newComb.combination.get(door.getSecond() + 1);
            newComb.combination.set(door.getSecond() + 1, right);
            newComb.combination.set(door.getSecond(), left);
            newComb.combination.set(door.getFirst(), tmp);
        }

        return newComb;
    }

}
