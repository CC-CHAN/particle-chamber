package com.sgcib.particle.demo.services;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class AnimateTests {

    @Test
    void one_r_only_speed_2() {
        var res = Animate.animate(2, "..R....");
        assertIterableEquals(List.of("..X....", "....X..", "......X", "......."), res);
    }

    @Test
    void min_r_l_speed_3() {
        var res = Animate.animate(3, "RR..LRL");
        assertIterableEquals(List.of("XX..XXX", ".X.XX..", "X.....X", "......."), res);
    }

    @Test
    void min_r_l_speed_2() {
        var res = Animate.animate(2, "LRLR.LRLR");
        assertIterableEquals(List.of("XXXX.XXXX", "X..X.X..X", ".X.X.X.X.", ".X.....X.", "........."), res);
    }

    @Test
    void mid_r_l_speed_10() {
        var res = Animate.animate(10, "RLRLRLRLRL");
        assertIterableEquals(List.of("XXXXXXXXXX", ".........."), res);
    }

    @Test
    void mid_empty_speed_1() {
        var res = Animate.animate(1, "...");
        assertIterableEquals(List.of("..."), res);
    }

    @Test
    void lrg_r_l_speed_1() {
        var res = Animate.animate(1, "LRRL.LR.LRR.R.LRRL.");
        assertIterableEquals(List.of("XXXX.XX.XXX.X.XXXX.", "..XXX..X..XX.X..XX.", ".X.XX.X.X..XX.XX.XX",
                "X.X.XX...X.XXXXX..X", ".X..XXX...X..XX.X..", "X..X..XX.X.XX.XX.X.", "..X....XX..XX..XX.X",
                ".X.....XXXX..X..XX.", "X.....X..XX...X..XX", ".....X..X.XX...X..X", "....X..X...XX...X..",
                "...X..X.....XX...X.", "..X..X.......XX...X", ".X..X.........XX...", "X..X...........XX..",
                "..X.............XX.", ".X...............XX", "X.................X", "..................."), res);
    }
}
