package com.eehmull.testCode.controller;

import com.eehmull.testCode.models.ChuckNorris;
import com.google.gson.Gson;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author eehmull
 */
public class ChuckNorrisController {

    private Client client = ClientBuilder.newClient();
    private static final String JSON_API_URI = "https://api.chucknorris.io/jokes/random";
    private Gson gson = new Gson();

    public ChuckNorris getDataJsonApi() {
        Response res = client
                .target(JSON_API_URI)
                .request(MediaType.APPLICATION_JSON)
                .get();
        ChuckNorris norris = gson.fromJson(res.readEntity(String.class), ChuckNorris.class);
        return norris;
    }
}
