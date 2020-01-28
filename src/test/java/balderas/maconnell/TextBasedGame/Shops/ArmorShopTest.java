package balderas.maconnell.TextBasedGame.Shops;

import balderas.maconnell.TextBasedGame.Menus.ArmorMenu;
import balderas.maconnell.TextBasedGame.Menus.ArmorSell;
import balderas.maconnell.TextBasedGame.Menus.MainMenu;
import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;
import balderas.maconnell.TextBasedGame.Tools.Armor;
import balderas.maconnell.TextBasedGame.io.Display;
import balderas.maconnell.TextBasedGame.io.Input;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.InputMismatchException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ArmorShopTest {

    ArmorShop armorShop;
    PlayerInventory playerInventory = new PlayerInventory();
    Display display = Mockito.mock(Display.class);
    Input scanner = Mockito.mock(Input.class);
    ArmorMenu armorMenu = Mockito.mock(ArmorMenu.class);
    ArmorSell armorSell = Mockito.mock(ArmorSell.class);
    MainMenu mainMenu = Mockito.mock(MainMenu.class);

    @Before
    public void setup(){
        armorShop = new ArmorShop(display, scanner, armorMenu, armorSell, mainMenu);
    }

    @Test
    public void armorShop_DisplaysCorrectMenu(){
        armorShop.displayMenu();
        verify(display).println(ArmorShop.MENUBAR);
        verify(display).println(ArmorShop.ARMOR_SHOP_LINE_1);
        verify(display).println(ArmorShop.ARMOR_SHOP_LINE_2);
        verify(display).println(ArmorShop.ARMOR_SHOP_LINE_3);
        verify(display).println(ArmorShop.ARMOR_SHOP_LINE_4);
        verify(display).println(ArmorShop.ARMOR_SHOP_LINE_5);
    }

    @Test
    public void armorShop_PrintsErrorMessage_WhenInputThrowsError(){
        when(scanner.nextInt()).thenThrow(new InputMismatchException());
        armorShop.captureInput();
        verify(display).println(ArmorShop.INVALID_COMMAND);
    }

    @Test
    public void armorShop_ReturnsFalse_WhenInputAboveRange(){
        assertEquals(false, armorShop.validateChoice(4));
    }

    @Test
    public void armorShop_ReturnsFalse_WhenInputBelowRange(){
        assertEquals(false, armorShop.validateChoice(0));
    }

    @Test
    public void armorShop_ReturnsTrue_WhenInputIsThree(){
        assertEquals(true, armorShop.validateChoice(3));
    }

    @Test
    public void armorShop_ReturnsTrue_WhenInputIsTwo(){
        assertEquals(true, armorShop.validateChoice(2));
    }

    @Test
    public void armorShop_ReturnsTrue_WhenInputIsOne(){
        assertEquals(true, armorShop.validateChoice(1));
    }

    @Test
    public void armorShop_OptionOne_ReturnsNoGold_IfPlayerHasNoGold(){
        playerInventory.setGold(0);
        armorShop.processOptions(playerInventory, 1);
        verify(display).println(ArmorShop.NOT_ENOUGH_GOLD);
    }

    @Test
    public void armorShop_OptionOne_ReturnsArmorBuyMenu_IfPlayerHasGold(){
        playerInventory.setGold(100);
        armorShop.processOptions(playerInventory, 1);
        verify(armorMenu).display(playerInventory);
    }

    @Test
    public void armorShop_OptionTwo_ReturnsArmorSellMenu(){
        armorShop.processOptions(playerInventory, 2);
        verify(armorSell).display(playerInventory);
    }

}