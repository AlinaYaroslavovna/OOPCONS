public class Radio {
    private int currentStation; // Номер текущей радиостанции
    private int currentVolume;   // Уровень громкости

    public Radio() {
        this.currentStation = 0; // Начальная станция
        this.currentVolume = 0;   // Начальная громкость
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station <= 9) {
            this.currentStation = station;
        } else {
            throw new IllegalArgumentException("Station must be between 0 and 9");
        }
    }

    public void next() {
        if (currentStation == 9) {
            currentStation = 0; // Переключение на нулевую станцию
        } else {
            currentStation++; // Переключение на следующую станцию
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = 9; // Переключение на девятую станцию
        } else {
            currentStation--; // Переключение на предыдущую станцию
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}
