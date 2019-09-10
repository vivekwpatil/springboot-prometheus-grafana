package com.java.engineering.springbootprometheusgrafana.resource;

import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldResource.class);

    @Timed(
        value = "HelloController.hello.request",
        histogram = true,
        extraTags = {"version", "1.0"}
    )
    @GetMapping(value = "/hello/{id}")
    public ResponseEntity hello(@PathVariable("id") String id) {
        switch (id) {
            case "1":
                LOG.info("*****************hello is called in case of 400 Bad Request*******************");
                return ResponseEntity.badRequest().body("bad request");
            case "2":
                LOG.info("*****************hello is called in case of 401 unauthorized*******************");
                return ResponseEntity.status(401).body("forbidden");
            case "3":
                LOG.info("*****************hello is called in case of 403 forbidden*******************");
                return ResponseEntity.status(403).body("forbidden");
            case "4":
                LOG.info("*****************hello is called in case of internal Server error *******************");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("internal Server error");
            default:
                LOG.info("*****************hello is called in case of Success Response *******************");
                return ResponseEntity.ok().body("Hello Java Engineers");

        }
    }
}
