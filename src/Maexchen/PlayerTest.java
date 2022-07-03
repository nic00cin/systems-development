package Maexchen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

      @Test
      void Player_Test() {
            Player player = new Player("Nikolai",12);
            assertEquals(player != null, true);
      }
            
      @Test
      void Player_decreasePointsTest() {
            Player player = new Player("Nikolai",12);
            player.decreasePoints();
            assertEquals(player.points == -1, true);
      }
      
      @Test
      void Player_getAgeTest() {
            Player player = new Player("Nikolai",12);
            assertEquals(player.getAge(), 12);
      }
      
      @Test
      void Player_getNameTest() {
            Player player = new Player("Nikolai",12);
            assertEquals(player.getName(), "Nikolai");
      }
      
      @Test
      void Player_getRolledTest() {
            Player player = new Player("Nikolai",12);
            player.rolled_n = 21;
            assertEquals(player.getRolled(), 21);
      }
      
      @Test
      void Player_getCalledTest() {
            Player player = new Player("Nikolai",12);
            player.called_n = 33;
            assertEquals(player.getCalled(), 33);
      }
      
      @Test
      void Player_setRolledTest() {
            Player player = new Player("Nikolai",12);
            player.setRolled(33);
            assertEquals(player.rolled_n == 33, true);
      }
      
      @Test
      void Player_setCalledTest() {
            Player player = new Player("Nikolai",12);
            player.setCalled(32);
            assertEquals(player.called_n == 32, true);
      }
      
      @Test
      void Player_getPointsTest() {
            Player player = new Player("Nikolai",12);
            assertEquals(player.getPoints() == 0, true);
      }
}
