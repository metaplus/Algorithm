package org.argo.algorithm.platform.leetcode.solution.queue;

import org.argo.algorithm.platform.leetcode.annotation.LeetcodeSolution;

import java.util.ArrayDeque;
import java.util.Deque;

@LeetcodeSolution(order = 286)
public class WallsAndGates {

    int room = 2147483647;
    int gate = 0;
    int wall = -1;
    int[][] rooms;
    int width;
    int height;
    Deque<GirdPos> posDeque = new ArrayDeque<>();

    static class GirdPos {
        int x;
        int y;

        public GirdPos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void wallsAndGates(int[][] rooms) {
        this.rooms = rooms;
        this.width = rooms.length;
        if (rooms.length == 0) {
            return;
        }
        this.height = rooms[0].length;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (gate != rooms[i][j]) continue;
                updateGateDistance(i, j);
            }
        }
    }

    private void updateGateDistance(int i, int j) {
        posDeque.clear();
        posDeque.add(new GirdPos(i, j));
        int step = 0;
        while (!posDeque.isEmpty()) {
            int roundSize = posDeque.size();
            step++;
            for (int k = 0; k < roundSize; k++) {
                GirdPos pos = posDeque.poll();
                if (pos.x + 1 < width) addPosIfNearer(pos.x + 1, pos.y, step);
                if (pos.x - 1 >= 0) addPosIfNearer(pos.x - 1, pos.y, step);
                if (pos.y + 1 < height) addPosIfNearer(pos.x, pos.y + 1, step);
                if (pos.y - 1 >= 0) addPosIfNearer(pos.x, pos.y - 1, step);
            }
        }
    }

    private void addPosIfNearer(int i, int j, int step) {
        if (gate >= rooms[i][j] || step >= rooms[i][j]) return;
        posDeque.add(new GirdPos(i, j));
        rooms[i][j] = step;
    }
}