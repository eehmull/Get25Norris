package com.eehmull.testCode.resources;

import com.eehmull.testCode.controller.ChuckNorrisController;
import com.eehmull.testCode.models.ChuckNorris;
import com.eehmull.testCode.threads.Proceso1;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
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

    /**
     * Utilize set, para así no se agregaran duplicados a la lista y varios 
     * hilos para optimizar el resultado.
     * @return
     * @throws InterruptedException 
     */
    @GET
    public Set<ChuckNorris> get25List() throws InterruptedException {
        Set<ChuckNorris> twentyFiveNorris = new LinkedHashSet<>();
        Set<ChuckNorris> twentyFiveNorris2 = new LinkedHashSet<>();
        Set<ChuckNorris> twentyFiveNorris3 = new LinkedHashSet<>();
        Set<ChuckNorris> twentyFiveNorris4 = new LinkedHashSet<>();
        Set<ChuckNorris> twentyFiveNorris5 = new LinkedHashSet<>();
        Set<ChuckNorris> mergeNorris;

        Proceso1 thread1 = new Proceso1(twentyFiveNorris, controller, 5);
        Proceso1 thread2 = new Proceso1(twentyFiveNorris2, controller, 5);
        Proceso1 thread3 = new Proceso1(twentyFiveNorris3, controller, 5);
        Proceso1 thread4 = new Proceso1(twentyFiveNorris4, controller, 5);
        Proceso1 thread5 = new Proceso1(twentyFiveNorris5, controller, 5);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        mergeNorris = Stream.of(twentyFiveNorris, twentyFiveNorris2, twentyFiveNorris3, twentyFiveNorris4, twentyFiveNorris5)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        /**
         * ------------------------------------------------------------------
         * Intenté con varios hilos agregar todo a la misma lista, pero mi
         * solución de arriba resulto ser mucho más rápida que esta.
         * ------------------------------------------------------------------
         */
//        Set<ChuckNorris> twentyFiveNorris = new LinkedHashSet<>();
//        AddNorrisThread thread1 = new AddNorrisThread(twentyFiveNorris, controller, 15);
//        AddNorrisThread thread2 = new AddNorrisThread(twentyFiveNorris, controller, 15);
//        AddNorrisThread thread3 = new AddNorrisThread(twentyFiveNorris, controller, 15);
//        AddNorrisThread thread4 = new AddNorrisThread(twentyFiveNorris, controller, 20);
//        AddNorrisThread thread5 = new AddNorrisThread(twentyFiveNorris, controller, 25);
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//        thread1.join();
//        thread2.join();
//        thread3.join();
//        thread4.join();
//        thread5.join();
//        System.out.println(twentyFiveNorris.size());
        return mergeNorris;
    }
}
