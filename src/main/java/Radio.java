public class Radio {
    private int currentStation;
    private int volume;
    private final int maxStations;
    private final int MAX_VOLUME = 100;
    private final int MIN_VOLUME = 0;

    // Конструктор с параметром
    public Radio(int maxStations) {
        this.maxStations = maxStations;
        this.currentStation = 0; // Начинаем с первой станции
        this.volume = 0; // Начинаем с минимальной громкости
    }

    // Конструктор по умолчанию
    public Radio() {
        this(10); // По умолчанию 10 станций
    }

    public void nextStation() {
        currentStation = (currentStation + 1) % maxStations;
    }

    public void prevStation() {
        currentStation = (currentStation - 1 + maxStations) % maxStations;
    }

    public void increaseVolume() {
        if (volume < MAX_VOLUME) {
            volume++;
        }
    }

    public void decreaseVolume() {
        if (volume > MIN_VOLUME) {
            volume--;
        }
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station < maxStations) {
            currentStation = station;
        }
    }

    public int getVolume() {
        return volume;
    }
}
