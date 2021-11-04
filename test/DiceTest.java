import com.company.Menu;
import com.company.casino.dice.Dice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

//@Test
public class DiceTest {


    @Test
    public void testSetGuessedNumber(){
        Dice dice = new Dice(null, null);
        dice.setGuessedNumber(1);
        dice.setGuessedNumber(3);

        int secondGuess = dice.getGuessedNumber();
        Assert.assertEquals(3, secondGuess);

        dice.setGuessedNumber(5);
        int thirdGuess = dice.getGuessedNumber();
        Assert.assertEquals(5, thirdGuess);
    }


    @Test
    public void shouldNotBeAbleToGuessHigherThenSix(){
        Dice dice = new Dice(null, null);
        boolean firstGuessValid = dice.guessNumber(5);
        boolean secondGuessValid = dice.guessNumber(8);
        Assert.assertTrue(firstGuessValid);
        Assert.assertFalse(secondGuessValid);
    }

    @Test
    public void testPlayAgainIfPlayerEnterYes() {
        Dice dice = new Dice(null, null);
        boolean answerIsYes = dice.playAgain("yes");
        boolean answerIsSomethingElse = dice.playAgain("something");
        Assert.assertTrue(answerIsYes);
        Assert.assertFalse(answerIsSomethingElse);
    }

}
