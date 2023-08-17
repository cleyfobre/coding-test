package dfsbfs;

import java.util.*;

public class LeetCode841 {

    static List<Boolean> visited;

    private static void dfs(int roomNumber, List<List<Integer>> rooms) {
        visited.set(roomNumber, true);
        System.out.print(roomNumber + " ");

        if (rooms.get(roomNumber).size() < 1)
            return;

        for (int cKey: rooms.get(roomNumber)) {
            if (!visited.get(cKey)) {
                dfs(cKey, rooms);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room0 = Arrays.asList(1);
        List<Integer> room1 = Arrays.asList(2);
        List<Integer> room2 = Arrays.asList(3);
        List<Integer> room3 = Arrays.asList();
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        visited = new ArrayList<>(Collections.nCopies(rooms.size(),false));

        dfs(0, rooms);

        for (Boolean v: visited) {
            if (!v) System.out.println(false);
        }

        System.out.println(true);
    }
}
