package balderas.maconnell.TextBasedGame.Menus;

import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;
import balderas.maconnell.TextBasedGame.Tools.Boots;
import balderas.maconnell.TextBasedGame.Tools.ChestPlate;
import balderas.maconnell.TextBasedGame.Tools.Helmet;
import balderas.maconnell.TextBasedGame.Tools.Leggings;
import balderas.maconnell.TextBasedGame.io.Display;
import balderas.maconnell.TextBasedGame.io.Input;
import jdk.tools.jaotc.Main;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.InputMismatchException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ArmorMenuTest {

    ArmorMenu armorMenu;
    Helmet helmet = new Helmet();
    ChestPlate chestPlate = new ChestPlate();
    Leggings leggings = new Leggings();
    Boots boots = new Boots();
    PlayerInventory playerInventory = new PlayerInventory();
    Input scanner = Mockito.mock(Input.class);
    Display display = Mockito.mock(Display.class);
    MainMenu mainMenu = Mockito.mock(MainMenu.class);

    @Before
    public void setup(){
        armorMenu = new ArmorMenu(display, scanner, mainMenu);
    }

    @Test
    public void armorMenu_PrintsErrorMessage_WhenInputThrowsError(){
        when(scanner.nextInt()).thenThrow(new InputMismatchException());
        armorMenu.captureInput();
        verify(display).println(ArmorMenu.INVALID_COMMAND);
    }

    @Test
    public void armorMenu_ReturnsFalse_WhenInputAboveRange(){
        assertEquals(false, armorMenu.validateChoice(5));
    }

    @Test
    public void armorMenu_ReturnFalse_WhenInputBelowRange(){
        assertEquals(false, armorMenu.validateChoice(0));
    }

    @Test
    public void armorMenu_ReturnTrue_WhenInputIsFour(){
        assertEquals(true, armorMenu.validateChoice(4));
    }

    @Test
    public void armorMenu_ReturnTrue_WhenInputIsThree(){
        assertEquals(true, armorMenu.validateChoice(3));
    }

    @Test
    public void armorMenu_ReturnTrue_WhenInputIsTwo(){
        assertEquals(true, armorMenu.validateChoice(2));
    }

    @Test
    public void armorMenu_ReturnTrue_WhenInputIsOne(){
        assertEquals(true, armorMenu.validateChoice(1));
    }

    @Test
    public void armorMenu_ReturnsDesiredHelmet(){
        assertEquals("Helmet", armorMenu.decideWeapon(1));
    }

    @Test
    public void armorMenu_ReturnsDesiredChestplate(){
        assertEquals("Chestplate", armorMenu.decideWeapon(2));
    }

    @Test
    public void armorMenu_ReturnsDesiredLeggings(){
        assertEquals("Leggings", armorMenu.decideWeapon(3));
    }

    @Test
    public void armorMenu_ReturnsDesiredBoots(){
        assertEquals("Boots", armorMenu.decideWeapon(4));
    }

    @Test
    public void armorMenu_LoseGoldOn_FirstBuyOption(){
        playerInventory.setGold(100);
        armorMenu.processOptions(1, playerInventory);
        assertEquals(90, playerInventory.getGold());
    }

    @Test
    public void armorMenu_LoseGoldOn_SecondBuyOption(){
        playerInventory.setGold(100);
        armorMenu.processOptions(2, playerInventory);
        assertEquals(90, playerInventory.getGold());
    }

    @Test
    public void armorMenu_LoseGoldOn_ThirdBuyOption(){
        playerInventory.setGold(100);
        armorMenu.processOptions(3, playerInventory);
        assertEquals(90, playerInventory.getGold());
    }

    @Test
    public void armorMenu_LoseGoldOn_FourthBuyOption(){
        playerInventory.setGold(100);
        armorMenu.processOptions(4, playerInventory);
        assertEquals(90, playerInventory.getGold());
    }

    @Test
    public void armorMenu_GainArmor_OnFirstBuyOption(){
        armorMenu.processOptions(1, playerInventory);
        assertEquals("Helmet", playerInventory.getInventory());
    }

    @Test
    public void armorMenu_GainArmor_OnSecondBuyOption(){
        armorMenu.processOptions(2, playerInventory);
        assertEquals("Chestplate", playerInventory.getInventory());
    }

    @Test
    public void armorMenu_GainArmor_OnThirdBuyOption(){
        armorMenu.processOptions(3, playerInventory);
        assertEquals("Leggings", playerInventory.getInventory());
    }

    @Test
    public void armorMenu_GainArmor_OnFourthBuyOption(){
        armorMenu.processOptions(4, playerInventory);
        assertEquals("Boots", playerInventory.getInventory());
    }


}