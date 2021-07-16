package com.sgcib.particle.demo.controllers;

import java.util.List;
import java.util.Map;

import com.sgcib.particle.demo.services.Animate;
import com.sgcib.particle.demo.services.AnimateParallel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnimateController {

    /**
     * get speed from json body, assume input is always valid
     * 
     * @param payload
     * @return
     */
    private int getSpeed(Map<String, Object> payload) {
        return (int) payload.get("speed");
    }

    /**
     * get chamber map from json body, assume input is always valid
     * 
     * @param payload
     * @return
     */
    private String getInit(Map<String, Object> payload) {
        return (String) payload.get("init");
    }

    @GetMapping("/animate")
    @ResponseBody
    List<String> animate(@RequestBody Map<String, Object> payload) {
        var speed = getSpeed(payload);
        var init = getInit(payload);
        return Animate.animate(speed, init);
    }

    @GetMapping("/animate-para")
    @ResponseBody
    List<String> animateParallel(@RequestBody Map<String, Object> payload) {
        var speed = getSpeed(payload);
        var init = getInit(payload);
        return AnimateParallel.animate(speed, init);
    }
}
