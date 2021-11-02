import com.company.Character;
import com.company.casino.dice.Dice;
import org.junit.Test;
import com.company.*;

public class TestUnit {
    Character character = new Character();
    Menu menu = new Menu(character);
    Dice dice = new Dice(menu, character);

    @Test
    public void checkMaxDiceSize() {
    dice.setGuessedNumber(3);
    int randomDiceNumber = 2;


    }

}
