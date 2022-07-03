package Maexchen;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointsTableTest {

	@Test
    void PlayerInfoUI_Test() {
          PlayerInfoUI playerinfo = new PlayerInfoUI();
          assertEquals(playerinfo.window != null, true);
    }
    
    @Test
    void PlayerInfoUI_createMainFieldTest() {
          PlayerInfoUI playerinfo = new PlayerInfoUI();
          assertEquals(playerinfo.window != null, true);
    }
    
    @Test
    void PlayerInfoUI_createTitlePanelTest() {
          PlayerInfoUI playerinfo = new PlayerInfoUI();
          assertEquals(playerinfo.titlePanel != null, true);
    }
    
    @Test
    void PlayerInfoUI_createInputPanelTest() {
          PlayerInfoUI playerinfo = new PlayerInfoUI();
          assertEquals(playerinfo.inputPanel != null, true);
    }
    
    @Test
    void PlayerInfoUI_createImagePanelTest() {
          PlayerInfoUI playerinfo = new PlayerInfoUI();
          assertEquals(playerinfo.imagePanel != null, true);
    }
}
