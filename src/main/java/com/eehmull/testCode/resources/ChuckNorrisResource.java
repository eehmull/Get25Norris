package com.eehmull.testCode.resources;

import com.eehmull.testCode.controller.ChuckNorrisController;
import com.eehmull.testCode.models.ChuckNorris;
import com.eehmull.testCode.threads.Proceso1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author eehmull
 */

@Path("/get-25")
@Produces(MediaType.APPLICATION_JSON)
public class ChuckNorrisResource {

    private final ChuckNorrisController controller = new ChuckNorrisController();

    @GET
    public List<ChuckNorris> get25List() throws InterruptedException {
        List<ChuckNorris> twentyFiveNorris = new ArrayList<>();
        List<ChuckNorris> twentyFiveNorris2 = new ArrayList<>();
        List<ChuckNorris> twentyFiveNorris3 = new ArrayList<>();
        List<ChuckNorris> mergeNorris = new ArrayList<>();

        Proceso1 thread1 = new Proceso1(twentyFiveNorris, controller);
        Proceso1 thread2 = new Proceso1(twentyFiveNorris2, controller);
        Proceso1 thread3 = new Proceso1(twentyFiveNorris3, controller);
        thread1.start();
        thread2.start();
        thread3.start();
        thread3.join();
        mergeNorris = Stream.of(twentyFiveNorris, twentyFiveNorris2, twentyFiveNorris3)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("First " + mergeNorris.size());
        if (mergeNorris.size() > 25) {
            int getSize = mergeNorris.size() - 25;
            for (int i = 1; i <= getSize; i++) {
                mergeNorris.remove(i);
            }
        }
        System.out.println(mergeNorris.size());
        return mergeNorris;
    }
}
