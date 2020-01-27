package balderas.maconnell.TextBasedGame.Shops;

import balderas.maconnell.TextBasedGame.Menus.MainMenu;
import balderas.maconnell.TextBasedGame.Menus.WeaponMenu;
import balderas.maconnell.TextBasedGame.Menus.WeaponSell;
import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;
import balderas.maconnell.TextBasedGame.io.Display;
import balderas.maconnell.TextBasedGame.io.Input;
import jdk.tools.jaotc.Main;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockingDetails;
import org.mockito.Mockito;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WeaponShopTest {

    WeaponShop weaponShop;
    PlayerInventory playerInventory = new PlayerInventory();
    Display display = Mockito.mock(Display.class);
    Input scanner = Mockito.mock(Input.class);
    WeaponMenu weaponMenu = Mockito.mock(WeaponMenu.class);
    WeaponSell weaponSell = Mockito.mock(WeaponSell.class);
    MainMenu mainMenu = Mockito.mock(MainMenu.class);

    @Before
    public void setup(){
        weaponShop = new WeaponShop(display, scanner, weaponMenu, weaponSell, mainMenu);
    }

    @Test
    public void weaponShop_DisplaysCorrectMenu(){
        weaponShop.displayMenu();
        verify(display).println(WeaponShop.MENUBAR);
        verify(display).println(WeaponShop.WEAPON_SHOP_LINE_1);
        verify(display).println(WeaponShop.WEAPON_SHOP_LINE_2);
        verify(display).println(WeaponShop.WEAPON_SHOP_LINE_3);
        verify(display).println(WeaponShop.WEAPON_SHOP_LINE_4);
        verify(display).println(WeaponShop.WEAPON_SHOP_LINE_5);
    }

    @Test
    public void weaponShop_PrintsErrorMessage_WhenInputThrowsError(){
        when(scanner.nextInt()).thenThrow(new InputMismatchException());
        weaponShop.captureInput();
        verify(display).println(WeaponShop.INVALID_COMMAND);
    }

    @Test
    public void weaponShop_ReturnsFalse_WhenInputAboveRange(){
        assertEquals(false, weaponShop.validateChoice(4));
    }

    @Test
    public void weaponShop_ReturnsFalse_WhenInputBelowRange(){
        assertEquals(false, weaponShop.validateChoice(0));
    }

    @Test
    public void weaponShop_ReturnsTrue_WhenInputIsThree(){
        assertEquals(true, weaponShop.validateChoice(3));
    }

    @Test
    public void weaponShop_ReturnsTrue_WhenInputIsTwo(){
        assertEquals(true, weaponShop.validateChoice(2));
    }

    @Test
    public void weaponShop_ReturnsTrue_WhenInputIsOne(){
        assertEquals(true, weaponShop.validateChoice(1));
    }

    @Test
    public void weaponShop_OptionOne_ReturnsNoGold_IfPlayerHasNoGold(){
        playerInventory.setGold(0);
        weaponShop.processOptions(playerInventory, 1);
        verify(display).println(WeaponShop.NOT_ENOUGH_GOLD);
    }

    @Test
    public void weaponShop_OptionOne_ReturnsWeaponBuyMenu_IfPlayerHasGold(){
        playerInventory.setGold(100);
        weaponShop.processOptions(playerInventory, 1);
        verify(weaponMenu).display(playerInventory);
    }

    @Test
    public void weaponShop_OptionTwo_ReturnsWeaponSellMenu(){
        weaponShop.processOptions(playerInventory, 2);
        verify(weaponSell).display(playerInventory);
    }

//    @Test
//    public void weaponShop_OptionThree_ReturnsBackToMainMenu(){
//        weaponShop.processOptions(playerInventory, 3);
//        verify(mainMenu).Display();
//    }

}