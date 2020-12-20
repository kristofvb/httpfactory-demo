package demo;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;

import javax.inject.Inject;

@Controller
public class DemoController {

    @Inject
    @Client("https://www.vrt.be")
    private RxHttpClient client;

    @Get(produces = MediaType.TEXT_HTML)
    HttpResponse<String> doGet() {
        client.toBlocking().retrieve("/");
        return HttpResponse.ok("some body");
    }

}
