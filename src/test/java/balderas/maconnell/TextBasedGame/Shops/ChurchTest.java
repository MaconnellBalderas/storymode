package balderas.maconnell.TextBasedGame.Shops;

import balderas.maconnell.TextBasedGame.Menus.UpgradeStats;
import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerStats;
import balderas.maconnell.TextBasedGame.io.Display;
import balderas.maconnell.TextBasedGame.io.Input;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.InputMismatchException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ChurchTest {

    Church church;
    PlayerStats playerStats = new PlayerStats();
    UpgradeStats upgradeStats = Mockito.mock(UpgradeStats.class);
    Display display = Mockito.mock(Display.class);
    Input scanner = Mockito.mock(Input.class);

    @Before
    public void setup(){
        church = new Church(display, scanner, upgradeStats, playerStats);
    }

    @Test
    public void church_DisplaysCorrectMenu(){
        church.displayMenu();
        verify(display).println(Church.MenuBar);
        verify(display).println(Church.CHURCH_SHOP_LINE_1);
        verify(display).println(Church.CHURCH_SHOP_LINE_2);
        verify(display).println(Church.CHURCH_SHOP_LINE_3);
        verify(display).println(Church.CHURCH_SHOP_LINE_4);
        verify(display).println(Church.CHURCH_SHOP_LINE_5);
    }

    @Test
    public void church_PrintsErrorMessage_WhenInputThrowsError(){
        when(scanner.nextInt()).thenThrow(new InputMismatchException());
        church.captureInput();
        verify(display).println(Church.INVALID_COMMAND);
    }

    @Test
    public void church_ReturnsFalse_WhenInputAboveRange(){
        assertEquals(false, church.validateChoice(4));
    }

    @Test
    public void church_ReturnsFalse_WhenInputBelowRange(){
        assertEquals(false, church.validateChoice(0));
    }

    @Test
    public void church_ReturnsTrue_WhenInputIsThree(){
        assertEquals(true, church.validateChoice(3));
    }

    @Test
    public void church_ReturnsTrue_WhenInputIsTwo(){
        assertEquals(true, church.validateChoice(2));
    }

    @Test
    public void church_ReturnsTrue_WhenInputIsOne(){
        assertEquals(true, church.validateChoice(1));
    }

    @Test
    public void church_OptionOne_ReturnsPlayerToFullHealth(){
        int fullHealth = 100;
        playerStats.setHealth(fullHealth);
        assertEquals(100, playerStats.getHealth());
    }

    @Test
    public void church_OptionTwo_ReturnsUpgradeStatsMenu(){
        church.processOptions(playerStats, 2);
        verify(upgradeStats).display(playerStats);
    }

}