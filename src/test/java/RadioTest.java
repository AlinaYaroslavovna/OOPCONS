import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    @Test
    public void testNextStation() {
        Radio radio = new Radio(10);
        radio.nextStation();
        assertEquals(1, radio.getCurrentStation());
        for (int i = 0; i < 9; i++) {
            radio.nextStation();
        }
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testVolumeIncrease() {
        Radio radio = new Radio();
        for (int i = 0; i < 101; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getVolume());
    }

    @Test
    public void testVolumeDecrease() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        assertEquals(0, radio.getVolume());
    }
}
