package com.gamePlay;

import com.gamePlay.controller.MyController;
import com.gamePlay.models.PlayerInput;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class GamePlayApplicationTests {

	@Test
	void contextLoads() {
	}


	private MyController myController = new MyController();
	String player1Input, player2Input, expectedResult, actualResult;

	@Test
	void generateRandomMoveForPlayer2() {
		actualResult = myController.generateRandomMoveForPlayer2();
		assertThat((actualResult.equals("Rock") || actualResult.equals("Paper") || actualResult.equals("Scissor"))).isTrue();
	}
	@Test
	void testGetResult() {

		// Test case 1
		player1Input = "Paper";
		player2Input = "Rock";
		expectedResult = "Win";
		actualResult = myController.getResult(player1Input, player2Input);
		assertThat(actualResult).isEqualTo(expectedResult);

		//Test case 2
		player1Input = "Rock";
		player2Input = "Scissor";
		expectedResult = "Win";
		actualResult = myController.getResult(player1Input, player2Input);
		assertThat(actualResult).isEqualTo(expectedResult);

		//Test case 3
		player1Input = "Scissor";
		player2Input = "Paper";
		expectedResult = "Win";
		actualResult = myController.getResult(player1Input, player2Input);
		assertThat(actualResult).isEqualTo(expectedResult);

		// Test case 4
		player1Input = "Rock";
		player2Input = "Paper";
		expectedResult = "Lose";
		actualResult = myController.getResult(player1Input, player2Input);
		assertThat(actualResult).isEqualTo(expectedResult);

		//Test case 5
		player1Input = "Paper";
		player2Input = "Scissor";
		expectedResult = "Lose";
		actualResult = myController.getResult(player1Input, player2Input);
		assertThat(actualResult).isEqualTo(expectedResult);

		//Test case 6
		player1Input = "Scissor";
		player2Input = "Rock";
		expectedResult = "Lose";
		actualResult = myController.getResult(player1Input, player2Input);
		assertThat(actualResult).isEqualTo(expectedResult);

		//Test case 7
		player1Input = "InvalidInput";
		player2Input = "Rock";
		expectedResult = "Wrong Input";
		actualResult = myController.getResult(player1Input, player2Input);
		assertThat(actualResult).isEqualTo(expectedResult);

		//Test case 8
		player1Input = "InvalidInput";
		player2Input = "Scissor";
		expectedResult = "Wrong Input";
		actualResult = myController.getResult(player1Input, player2Input);
		assertThat(actualResult).isEqualTo(expectedResult);

		//Test case 9
		player1Input = "InvalidInput";
		player2Input = "Paper";
		expectedResult = "Wrong Input";
		actualResult = myController.getResult(player1Input, player2Input);
		assertThat(actualResult).isEqualTo(expectedResult);

		//Test case 10
		player1Input = "Rock";
		player2Input = "InvalidInput";
		expectedResult = "Wrong Input";
		actualResult = myController.getResult(player1Input, player2Input);
		assertThat(actualResult).isEqualTo(expectedResult);

		//Test case 11
		player1Input = "Scissor";
		player2Input = "InvalidInput";
		expectedResult = "Wrong Input";
		actualResult = myController.getResult(player1Input, player2Input);
		assertThat(actualResult).isEqualTo(expectedResult);

		//Test case 12
		player1Input = "Paper";
		player2Input = "InvalidInput";
		expectedResult = "Wrong Input";
		actualResult = myController.getResult(player1Input, player2Input);
		assertThat(actualResult).isEqualTo(expectedResult);
	}


	@Test
	void gamePlay() {

		//Test 1
		player1Input = "Rock";
		actualResult = myController.gamePlay(new PlayerInput(player1Input)).getResult();
		assertThat((actualResult.equals("Win") || actualResult.equals("Lose") || actualResult.equals("Tie"))).isTrue();

		//Test 2
		player1Input = "Paper";
		actualResult = myController.gamePlay(new PlayerInput(player1Input)).getResult();
		assertThat((actualResult.equals("Win") || actualResult.equals("Lose") || actualResult.equals("Tie"))).isTrue();

		//Test 3
		player1Input = "Scissor";
		actualResult = myController.gamePlay(new PlayerInput(player1Input)).getResult();
		assertThat((actualResult.equals("Win") || actualResult.equals("Lose") || actualResult.equals("Tie"))).isTrue();

		//Test 4
		player1Input = "Invalid Input";
		actualResult = myController.gamePlay(new PlayerInput(player1Input)).getResult();
		assertThat(actualResult.equals("Wrong Input")).isTrue();
	}

}
