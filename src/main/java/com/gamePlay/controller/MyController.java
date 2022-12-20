package com.gamePlay.controller;

import com.gamePlay.models.GameResult;
import com.gamePlay.models.PlayerInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/gamePlay")
public class MyController {

    Logger logger = LoggerFactory.getLogger(MyController.class);


    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome back";
    }

    // This will take a parameter of object(PlayerInput) from endpoint through restApi
    // and will return an object(GameResult)
    @PostMapping("/play")
    public GameResult gamePlay(@RequestBody PlayerInput player1Input) {

        if(player1Input.getInput().isEmpty()) {
            logger.error("Recieved parameter is empty.");
        }

        String player2Input = generateRandomMoveForPlayer2();
        String result = getResult(player1Input.getInput(), player2Input);
        GameResult gameResult = new GameResult(result);
        return gameResult;

    }

    // Funtion to generate random move
    public String generateRandomMoveForPlayer2() {

        //Generating 1-3 random integer
        int min = 1;
        int max = 3;
        int b = (int)(Math.random()*(max-min+1)+min);

        //Mapping 1-3 integer to moves
        HashMap<Integer, String> mp = new HashMap<>();
        mp.put(1, "Rock");
        mp.put(2, "Paper");
        mp.put(3, "Scissor");

        return mp.get(b);
    }

    // Funtion to check if palayer wins, lose or tie or return wrong input if input is invalid
    public String getResult(String player1Input, String player2Input) {

        if(player1Input.equals("Rock")) {
            if(player2Input.equals("Rock")) return "Tie";
            else if(player2Input.equals("Paper")) return "Lose";
            else if(player2Input.equals("Scissor")) return "Win";
            else return "Wrong Input";
        }
        else if(player1Input.equals("Paper")) {
            if(player2Input.equals("Rock")) return "Win";
            else if(player2Input.equals("Paper")) return "Tie";
            else if(player2Input.equals("Scissor")) return "Lose";
            else return "Wrong Input";
        }
        else if(player1Input.equals("Scissor")){
            if(player2Input.equals("Rock")) return "Lose";
            else if(player2Input.equals("Paper")) return "Win";
            else if(player2Input.equals("Scissor"))  return "Tie";
            else return "Wrong Input";
        }
        else return "Wrong Input";

    }
}
