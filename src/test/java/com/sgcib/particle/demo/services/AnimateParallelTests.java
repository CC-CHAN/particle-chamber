package com.sgcib.particle.demo.services;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class AnimateParallelTests {

    @Test
    void one_r_only_speed_2() {
        var res = AnimateParallel.animate(2, "..R....");
        assertIterableEquals(List.of("..X....", "....X..", "......X", "......."), res);
    }

    @Test
    void min_r_l_speed_3() {
        var res = AnimateParallel.animate(3, "RR..LRL");
        assertIterableEquals(List.of("XX..XXX", ".X.XX..", "X.....X", "......."), res);
    }

    @Test
    void min_r_l_speed_2() {
        var res = AnimateParallel.animate(2, "LRLR.LRLR");
        assertIterableEquals(List.of("XXXX.XXXX", "X..X.X..X", ".X.X.X.X.", ".X.....X.", "........."), res);
    }

    @Test
    void mid_r_l_speed_10() {
        var res = AnimateParallel.animate(10, "RLRLRLRLRL");
        assertIterableEquals(List.of("XXXXXXXXXX", ".........."), res);
    }

    @Test
    void mid_empty_speed_1() {
        var res = AnimateParallel.animate(1, "...");
        assertIterableEquals(List.of("..."), res);
    }

    @Test
    void lrg_r_l_speed_1() {
        var res = AnimateParallel.animate(1, "LRRL.LR.LRR.R.LRRL.");
        assertIterableEquals(List.of("XXXX.XX.XXX.X.XXXX.", "..XXX..X..XX.X..XX.", ".X.XX.X.X..XX.XX.XX",
                "X.X.XX...X.XXXXX..X", ".X..XXX...X..XX.X..", "X..X..XX.X.XX.XX.X.", "..X....XX..XX..XX.X",
                ".X.....XXXX..X..XX.", "X.....X..XX...X..XX", ".....X..X.XX...X..X", "....X..X...XX...X..",
                "...X..X.....XX...X.", "..X..X.......XX...X", ".X..X.........XX...", "X..X...........XX..",
                "..X.............XX.", ".X...............XX", "X.................X", "..................."), res);
    }

    @Test
    void lrg_r_l_speed_2() {
        var chamber = "LRRL.LR.LRR.R.LRRL.LRRL.LR.LRR.R.LRRL.LRR.R.LRRL.L";
        var res1 = AnimateParallel.animate(1, chamber);
        var res2 = Animate.animate(1, chamber);
        assertIterableEquals(res2, res1);
    }

    @Test
    void lrg_r_l_speed_3() {
        // length of input out of scope, just have a try
        var chamber = "LRRL.LR.LRR.R.LRRL.LRRL.LR.LRR.R.LRRL.LRR.R.LRRL.LLRRL.LR.LRR.R.LRRL.LRRL.LR.LRR.R.LRRL.LRR.R.LRRL.LLRRL.LR.LRR.R.LRRL.LRRL.LR.LRR.R.LRRL.LRR.R.LRRL.LLRRL.LR.LRR.R.LRRL.LRRL.LR.LRR.R.LRRL.LRR.R.LRRL.LLRRL.LR.LRR.R.LRRL.LRRL.LR.LRR.R.LRRL.LRR.R.LRRL.LLRRL.LR.LRR.R.LRRL.LRRL.LR.LRR.R.LRRL.LRR.R.LRRL.LLRRL.LR.LRR.R.LRRL.LRRL.LR.LRR.R.LRRL.LRR.R.LRRL.LLRRL.LR.LRR.R.LRRL.LRRL.LR.LRR.R.LRRL.LRR.R.LRRL.LLRRL.LR.LRR.R.LRRL.LRRL.LR.LRR.R.LRRL.LRR.R.LRRL.LLRRL.LR.LRR.R.LRRL.LRRL.LR.LRR.R.LRRL.LRR.R.LRRL.LLRRL.LR.LRR.R.LRRL.LRRL.LR.LRR.R.LRRL.LRR.R.LRRL.LLRRL.LR.LRR.R.LRRL.LRRL.LR.LRR.R.LRRL.LRR.R.LRRL.LLRRL.LR.LRR.R.LRRL.LRRL.LR.LRR.R.LRRL.LRR.R.LRRL.LLRRL.LR.LRR.R.LRRL.LRRL.LR.LRR.R.LRRL.LRR.R.LRRL.LLRRL.LR.LRR.R.LRRL.LRRL.LR.LRR.R.LRRL.LRR.R.LRRL.L";
        var res1 = AnimateParallel.animate(1, chamber);
        var res2 = Animate.animate(1, chamber);
        assertIterableEquals(res2, res1);
    }
}
