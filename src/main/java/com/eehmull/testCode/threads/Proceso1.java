package com.eehmull.testCode.threads;

import com.eehmull.testCode.controller.ChuckNorrisController;
import com.eehmull.testCode.models.ChuckNorris;
import java.util.List;
import java.util.Set;

/**
 *
 * @author eehmull
 */
public class Proceso1 extends Thread {

    private Set<ChuckNorris> listNorris;
    private ChuckNorrisController controller;
    private final Integer value;

    public Proceso1(Set<ChuckNorris> listNorris, ChuckNorrisController controller, Integer value) {
        this.listNorris = listNorris;
        this.controller = controller;
        this.value = value;
    }

    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            this.listNorris.add(controller.getDataJsonApi());
            if (listNorris.size() == value) {
                flag = false;
            }
        }
    }

    public Set<ChuckNorris> getListNorris() {
        return listNorris;
    }
}
