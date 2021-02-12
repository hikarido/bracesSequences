package generators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BracesGenerator {
    private List<BracesCombination> combinations;

    public BracesGenerator() {
    }

    public List<String> generate(int n) {
        combinations = new ArrayList<>();
        BracesCombination initPortal = new BracesCombination(n);
        searchAllCombinationsOf(initPortal);
        List<String> result = combinations
                .stream()
                .map(BracesCombination::toString)
                .collect(Collectors.toList());
        return  result;
    }

    private void searchAllCombinationsOf(BracesCombination combination){
        if(combinations.contains(combination)){
            return;
        }
        else {
            combinations.add(combination);
            List<Pair<Integer, Integer>> doors = combination.searchOfAllDoors();
            for(Pair<Integer, Integer> door: doors){
                BracesCombination movedToLeft = combination.moveDoor(door, true);
                BracesCombination movedToRight = combination.moveDoor(door, false);

                if(!combinations.contains(movedToLeft)){
                    searchAllCombinationsOf(movedToLeft);
                }

                if(!combinations.contains(movedToRight)){
                    searchAllCombinationsOf(movedToRight);
                }
            }

        }
    }
}
