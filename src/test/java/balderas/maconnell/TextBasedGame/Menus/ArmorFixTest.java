package balderas.maconnell.TextBasedGame.Menus;

import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;
import balderas.maconnell.TextBasedGame.Tools.*;
import balderas.maconnell.TextBasedGame.io.Display;
import balderas.maconnell.TextBasedGame.io.Input;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.InputMismatchException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ArmorFixTest {

    ArmorFix armorFix;
    Helmet helmet = new Helmet();
    ChestPlate chestPlate = new ChestPlate();
    Leggings leggings = new Leggings();
    Boots boots = new Boots();
    PlayerInventory playerInventory = new PlayerInventory();
    Input scanner = Mockito.mock(Input.class);
    Display display = Mockito.mock(Display.class);
    MainMenu mainMenu = Mockito.mock(MainMenu.class);;

    @Before
    public void setup(){
        armorFix = new ArmorFix(display, scanner, mainMenu);
    }

    @Test
    public void armorFix_ReturnsEmpty_IfInventoryHasNoItems(){
        armorFix.displayMenu(playerInventory);
        verify(display).println(ArmorFix.MENUBAR);
        verify(display).println(ArmorFix.ARMORFIX_LINE_1);
    }

    @Test
    public void armorFix_ReturnsListOfItems_IfInventoryHasItems(){
        playerInventory.addItem("helmet");
        armorFix.displayMenu(playerInventory);
        verify(display).println(ArmorFix.MENUBAR);
        verify(display).println(ArmorFix.ARMORFIX_LINE_1);
        assertEquals("helmet", playerInventory.getInventory());
    }

    @Test
    public void armorFix_PrintsErrorMessage_WhenInputThrowsError(){
        when(scanner.nextLine()).thenThrow(new InputMismatchException());
        armorFix.captureInput();
        verify(display).println(ArmorFix.INVALID_COMMAND);
    }

    @Test
    public void armorFix_ReturnsFalse_WhenInputIsIncorrect(){
        assertEquals(false, armorFix.validateChoice("hat"));
    }

    @Test
    public void armorFix_ReturnsTrue_WhenInputIsHelmet(){
        assertEquals(true, armorFix.validateChoice("Helmet"));
    }

    @Test
    public void armorFix_ReturnsTrue_WhenInputIsChestPlate(){
        assertEquals(true, armorFix.validateChoice("Chestplate"));
    }

    @Test
    public void armorFix_ReturnsTrue_WhenInputIsLeggings(){
        assertEquals(true, armorFix.validateChoice("Leggings"));
    }

    @Test
    public void armorFix_ReturnsTrue_WhenInputIsBoots(){
        assertEquals(true, armorFix.validateChoice("Boots"));
    }

    @Test
    public void armorFix_OptionsOne_ReturnsLessGold(){
        playerInventory.setGold(100);
        armorFix.processOptions("Helmet", playerInventory, helmet, chestPlate, leggings, boots);
        assertEquals(90, playerInventory.getGold());
    }

    @Test
    public void armorFix_OptionsOne_ReturnsMoreDurability(){
        playerInventory.setGold(100);
        helmet.setDurability(90);
        armorFix.processOptions("Helmet", playerInventory, helmet, chestPlate, leggings, boots);
        assertEquals(95, helmet.getDurability());
    }

    @Test
    public void armorFix_OptionTwo_ReturnsLessGold(){
        playerInventory.setGold(100);
        armorFix.processOptions("Chestplate", playerInventory, helmet, chestPlate, leggings, boots);
        assertEquals(90, playerInventory.getGold());
    }

    @Test
    public void armorFix_OptionTwo_ReturnsMoreDurability(){
        playerInventory.setGold(100);
        chestPlate.setDurability(90);
        armorFix.processOptions("Chestplate", playerInventory, helmet, chestPlate, leggings, boots);
        assertEquals(95, chestPlate.getDurability());
    }

    @Test
    public void armorFix_OptionThree_ReturnsLessGold(){
        playerInventory.setGold(100);
        armorFix.processOptions("Leggings", playerInventory, helmet, chestPlate, leggings, boots);
        assertEquals(90, playerInventory.getGold());
    }

    @Test
    public void armorFix_OptionThree_ReturnsMoreDurability(){
        playerInventory.setGold(100);
        leggings.setDurability(90);
        armorFix.processOptions("Leggings", playerInventory, helmet, chestPlate, leggings, boots);
        assertEquals(95, leggings.getDurability());
    }

    @Test
    public void armorFix_OptionFour_ReturnsLessGold(){
        playerInventory.setGold(100);
        armorFix.processOptions("Boots", playerInventory, helmet, chestPlate, leggings, boots);
        assertEquals(90, playerInventory.getGold());
    }

    @Test
    public void armorFix_OptionFour_ReturnsMoreDurability(){
        playerInventory.setGold(100);
        boots.setDurability(90);
        armorFix.processOptions("Boots", playerInventory, helmet, chestPlate, leggings, boots);
        assertEquals(95, boots.getDurability());
    }

}