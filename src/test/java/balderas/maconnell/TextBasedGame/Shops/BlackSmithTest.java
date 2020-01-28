package balderas.maconnell.TextBasedGame.Shops;

import balderas.maconnell.TextBasedGame.Menus.ArmorFix;
import balderas.maconnell.TextBasedGame.Menus.ArmorUpgrade;
import balderas.maconnell.TextBasedGame.Menus.WeaponFix;
import balderas.maconnell.TextBasedGame.Menus.WeaponUpgrade;
import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;
import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerStats;
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

public class BlackSmithTest {

    BlackSmith blackSmith;
    Axe axe;
    Bow bow;
    Spear spear;
    Sword sword;

    Helmet helmet;
    ChestPlate chestPlate;
    Leggings leggings;
    Boots boots;

    PlayerInventory playerInventory = new PlayerInventory();
    PlayerStats playerStats = new PlayerStats();

    WeaponUpgrade weaponUpgrade = Mockito.mock(WeaponUpgrade.class);
    WeaponFix weaponFix = Mockito.mock(WeaponFix.class);
    ArmorUpgrade armorUpgrade = Mockito.mock(ArmorUpgrade.class);
    ArmorFix armorFix = Mockito.mock(ArmorFix.class);
    Input scanner = Mockito.mock(Input.class);
    Display display = Mockito.mock(Display.class);

    @Before
    public void setup(){
        blackSmith = new BlackSmith(scanner, display, weaponUpgrade, weaponFix, armorUpgrade, armorFix);
    }

    @Test
    public void blackSmith_DisplaysCorrectMenu(){
        blackSmith.displayMenu();
        verify(display).println(BlackSmith.MenunBar);
        verify(display).println(BlackSmith.BLACKSMITH_LINE_1);
        verify(display).println(BlackSmith.BLACKSMITH_LINE_2);
        verify(display).println(BlackSmith.BLACKSMITH_LINE_3);
        verify(display).println(BlackSmith.BLACKSMITH_LINE_4);
        verify(display).println(BlackSmith.BLACKSMITH_LINE_5);
        verify(display).println(BlackSmith.BLACKSMITH_LINE_6);
        verify(display).println(BlackSmith.BLACKSMITH_LINE_7);
    }

    @Test
    public void blackSmith_PrintsErrorMessage_WhenInputThrowsError(){
        when(scanner.nextInt()).thenThrow(new InputMismatchException());
        blackSmith.captureInput();
        verify(display).println(BlackSmith.INVALID_COMMAND);
    }

    @Test
    public void blackSmith_ReturnsFalse_WHenInputAboveRange(){
        assertEquals(false, blackSmith.validateChoice(6));
    }

    @Test
    public void blackSmith_ReturnsFalse_WhenInputBelowRange(){
        assertEquals(false, blackSmith.validateChoice(0));
    }

    @Test
    public void blackSmith_ReturnsTrue_WhenInputIsFive(){
        assertEquals(true, blackSmith.validateChoice(5));
    }

    @Test
    public void blackSmith_ReturnsTrue_WhenInputIsFour(){
        assertEquals(true, blackSmith.validateChoice(4));
    }

    @Test
    public void blackSmith_ReturnsTrue_WhenInputIsThree(){
        assertEquals(true, blackSmith.validateChoice(3));
    }

    @Test
    public void blackSmith_ReturnsTrue_WhenInputIsTwo(){
        assertEquals(true, blackSmith.validateChoice(2));
    }

    @Test
    public void blackSmith_ReturnsTrue_WhenInputIsOne(){
        assertEquals(true, blackSmith.validateChoice(1));
    }

    @Test
    public void blackSmith_OptionOne_ReturnsNoGold_IfPlayerHasNoGold(){
        playerInventory.setGold(0);
        blackSmith.processOptions(1, playerInventory, axe, spear, bow, sword, playerStats, helmet, chestPlate, leggings, boots);
        verify(display).println(BlackSmith.NOT_ENOUGH_GOLD);
    }

    @Test
    public void blackSmith_OptionOne_ReturnsWeaponUpgradeMenu_IfPlayerHasGold(){
        playerInventory.setGold(100);
        blackSmith.processOptions(1, playerInventory, axe, spear, bow, sword, playerStats, helmet, chestPlate, leggings, boots);
        verify(weaponUpgrade).display(playerInventory, axe, bow, spear, sword);
    }

    @Test
    public void blackSmith_OptionTwo_ReturnsWeaponFixMenu(){
        blackSmith.processOptions(2, playerInventory, axe, spear, bow, sword, playerStats, helmet, chestPlate, leggings, boots);
        verify(weaponFix).display(playerInventory, axe, bow, spear, sword);
    }

    @Test
    public void blackSmith_OptionThree_ReturnsArmorUpgradeMenu(){
        blackSmith.processOptions(3, playerInventory, axe, spear, bow, sword, playerStats, helmet, chestPlate, leggings, boots);
        verify(armorUpgrade).display(playerInventory, playerStats);
    }

    @Test
    public void blackSmith_OptionFour_ReturnsArmorFixMenu(){
        blackSmith.processOptions(4, playerInventory, axe, spear, bow, sword, playerStats, helmet, chestPlate, leggings, boots);
        verify(armorFix).display(playerInventory, helmet, chestPlate, leggings, boots);
    }

}