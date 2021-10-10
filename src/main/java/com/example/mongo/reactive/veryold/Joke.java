package com.example.mongo.reactive.veryold;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Joke implements Serializable {

    private String setup;
    private String punchline;

}