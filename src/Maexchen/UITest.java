package Maexchen;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class UITest {

      @Test
      void UI_Test() {
            UI first_ui = new UI();
            assertEquals(first_ui.window != null, true);
      }
      
      @Test
      void UI_createMainFieldTest() {
            UI first_ui = new UI();
            first_ui.createMainField();
            assertEquals(first_ui.window != null, true);
      }
      
      @Test
      void UI_createTitlePanelTest() {
            UI first_ui = new UI();
            first_ui.createTitlePanel();
            assertEquals(first_ui.titlePanel != null, true);
      }

      @Test
      void UI_createInputPanelTest() {
            UI first_ui = new UI();
            first_ui.createInputPanel();
            assertEquals(first_ui.inputPanel != null, true);
      }
      
      @Test
      void UI_createImagePanelTest() {
            UI first_ui = new UI();
            first_ui.createImagePanel();
            assertEquals(first_ui.imagePanel != null, true);
      }
}