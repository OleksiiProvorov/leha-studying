package Weather;

public class Weather {
    private Double minTemp;
    private Double maxTemp;

    public Weather(Double minTemp, Double maxTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public String getTempInfo() {
        return "Min. Temp: " + minTemp + "\n"
                + "Max. Temp: " + maxTemp;
    }
}
