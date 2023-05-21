package com.game.rockpaperscissor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RockPaperScissorApplication {

    public static void main(String[] args) {
        log.info("Welcome to Rock Paper Scissor Application");
        SpringApplication.run(RockPaperScissorApplication.class, args);
    }

}
