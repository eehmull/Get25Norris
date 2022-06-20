package com.eehmull.testCode.threads;

import com.eehmull.testCode.controller.ChuckNorrisController;
import com.eehmull.testCode.models.ChuckNorris;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author eehmull
 */
public class AddNorrisThread extends Thread {

    private Set<ChuckNorris> twentyFiveNorris;
    private final ChuckNorrisController controller;
    private Integer value;

    public AddNorrisThread(Set<ChuckNorris> twentyFiveNorris, ChuckNorrisController controller, Integer value) {
        this.twentyFiveNorris = twentyFiveNorris;
        this.controller = controller;
        this.value = value;
    }

    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            this.twentyFiveNorris.add(controller.getDataJsonApi());
            if (this.twentyFiveNorris.size() >= value) {
                flag = false;
            }
        }
    }

    public Set<ChuckNorris> getTwentyFiveNorris() {
        return twentyFiveNorris;
    }
}
