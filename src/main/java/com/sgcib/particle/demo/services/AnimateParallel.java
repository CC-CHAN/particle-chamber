package com.sgcib.particle.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AnimateParallel {

    /**
     * get positions for one particle in all time unit
     * 
     * @param start
     * @param c
     * @param limit
     * @param speed
     * @return
     */
    private static List<Integer> getPositions(int start, char c, int limit, int speed) {
        var l = new ArrayList<Integer>(limit);
        var pos = start;
        if (c == 'L') {
            do {
                l.add(pos);
                pos -= speed;
            } while (pos >= 0);
        } else if (c == 'R') {
            do {
                l.add(pos);
                pos += speed;
            } while (pos < limit);
        }
        return l;
    }

    private static char[][] initEmptyChambers(int length, int limit) {
        var chars = new char[length][limit];
        for (var row : chars)
            Arrays.fill(row, '.');
        return chars;
    }

    public static List<String> animate(int speed, String init) {
        var chamber = init.toCharArray();
        var limit = chamber.length;
        List<List<Integer>> l = IntStream.range(0, limit).parallel()
                // only keep index with L or R
                .filter(x -> chamber[x] != '.')
                // get position list for all valid particles
                .mapToObj(x -> AnimateParallel.getPositions(x, chamber[x], limit, speed))
                // nested list
                .collect(Collectors.toList());

        // init empty chambers
        var maxLength = l.stream().map(List::size).max(Comparator.comparingInt(x -> x)).orElse(0) + 1;
        var chamberMap = initEmptyChambers(maxLength, limit);
        // assign X to chamber map
        l.parallelStream().forEach(x -> {
            for (var i = 0; i < x.size(); i++) {
                chamberMap[i][x.get(i)] = 'X';
            }
        });

        return Arrays.stream(chamberMap).map(String::new).collect(Collectors.toList());
    }
}
