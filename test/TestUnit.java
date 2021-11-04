import com.company.Character;
import com.company.casino.blackjack.Blackjack;
import com.company.casino.dice.Dice;
import org.junit.Assert;
import org.junit.Test;
import com.company.*;

public class TestUnit {
    Character character = new Character();
    Menu menu = new Menu(character);
    Dice dice = new Dice(menu, character);
    Blackjack blackjack = new Blackjack(character, menu);

    @Test
    public void testRepayBet() {
        int sum = GameMenu.repayBet(20,200);
        Assert.assertEquals(240, sum);
    }

}
