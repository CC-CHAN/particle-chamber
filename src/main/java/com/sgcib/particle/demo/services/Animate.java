package com.sgcib.particle.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Animate {

    private enum Block {
        L, R, LR, EMPTY;

        /**
         * convert direction of particle to @see Block
         * 
         * @param c
         * @return
         */
        public static Block fromChar(char c) {
            return c == 'L' ? Block.L : c == 'R' ? Block.R : Block.EMPTY;
        }
    }

    /**
     * check if no any particles in the chamber
     * 
     * @param blocks
     * @return
     */
    private static boolean isClear(Block[] blocks) {
        return Arrays.stream(blocks).allMatch(x -> x == Block.EMPTY);
    }

    /**
     * convert given string to block array for further processing
     * 
     * @param chamber
     * @return
     */
    private static Block[] initBlocks(String chamber) {
        return chamber.chars().mapToObj(x -> Block.fromChar((char) x)).toArray(Block[]::new);
    }

    /**
     * calculate position of particles for next time unit
     * 
     * @param speed
     * @param blocks
     * @return
     */
    private static Block[] getNext(int speed, Block[] blocks) {
        var next = new Block[blocks.length];
        Arrays.fill(next, Block.EMPTY);
        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] == Block.R || blocks[i] == Block.LR) {
                var p = i + speed;
                // ignore if out of chamber
                if (p < blocks.length) {
                    next[p] = next[p] == Block.EMPTY ? Block.R : Block.LR;
                }
            }
            if (blocks[i] == Block.L || blocks[i] == Block.LR) {
                var p = i - speed;
                if (p >= 0) {
                    next[p] = next[p] == Block.EMPTY ? Block.L : Block.LR;
                }
            }
        }
        return next;
    }

    /**
     * convert particles to [X/.] mapping
     * 
     * @param blocks
     * @return
     */
    private static String getOccupied(Block[] blocks) {
        return Arrays.stream(blocks).map(x -> x != Block.EMPTY ? "X" : ".").collect(Collectors.joining());
    }

    public static List<String> animate(int speed, String init) {
        var result = new ArrayList<String>();
        var cur = Animate.initBlocks(init);

        // get the position of particle in each time unit
        // until the chamber has no particles anymore
        while (!Animate.isClear(cur)) {
            var l = Animate.getOccupied(cur);
            result.add(l);
            cur = Animate.getNext(speed, cur);
        }
        var l = Animate.getOccupied(cur);
        result.add(l);

        return result;
    }
}
