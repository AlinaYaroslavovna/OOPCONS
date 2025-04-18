import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    private Radio radio;

    @BeforeEach
    void setUp() {
        radio = new Radio();
    }

    @Test
    void testInitialStationAndVolume() {
        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void testSetCurrentStationValid() {
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void testSetCurrentStationInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            radio.setCurrentStation(10);
        });
        assertEquals("Station must be between 0 and 9", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            radio.setCurrentStation(-1);
        });
        assertEquals("Station must be between 0 and 9", exception.getMessage());
    }

    @Test
    void testNextStation() {
        radio.setCurrentStation(8);
        radio.next();
        assertEquals(9, radio.getCurrentStation());

        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testPrevStation() {
        radio.setCurrentStation(1);
        radio.prev();
        assertEquals(0, radio.getCurrentStation());

        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void testIncreaseVolume() {
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());

        for (int i = 0; i < 99; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());

        radio.increaseVolume(); // Попытка увеличить громкость выше 100
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void testDecreaseVolume() {
        for (int i = 0; i < 50; i++) {
            radio.increaseVolume();
        }

        for (int i = 0; i < 50; i++) {
            radio.decreaseVolume();
        }

        assertEquals(0, radio.getCurrentVolume());
        radio.decreaseVolume(); // Попытка уменьшить громкость ниже 0
        assertEquals(0, radio.getCurrentVolume());
    }
}
