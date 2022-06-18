package com.eehmull.testCode.threads;

import com.eehmull.testCode.controller.ChuckNorrisController;
import com.eehmull.testCode.models.ChuckNorris;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author eehmull
 */
public class Proceso1 extends Thread {

    private List<ChuckNorris> listNorris;
    private ChuckNorrisController controller;

    public Proceso1(List<ChuckNorris> listNorris, ChuckNorrisController controller) {
        this.listNorris = listNorris;
        this.controller = controller;
    }

    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            this.listNorris.add(controller.getDataJsonApi());
            if (listNorris.size() == 10) {
//                this.listNorris = listNorris.stream().distinct().collect(Collectors.toList());
                flag = false;
            }
        }
    }

    public List<ChuckNorris> getListNorris() {
        return listNorris;
    }
}
