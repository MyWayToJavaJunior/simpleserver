package model;

/**
 * Created by User on 13.03.2017.
 */
public class Status {
    static float count = 1;

    float voltage;
    float amperage;
    float charge;
    float pressure;
    float humidity;
    float temperature_cpu;
    float temperature_hull;

    public Status() {
        this.voltage = (float) (0.1*count);
        this.amperage = (float) (0.1*count);
        this.charge = (float) (10*count);
        this.pressure = (float) (0.1*count);
        this.humidity = (float) (0.1*count);
        this.temperature_cpu = (float) (0.1*count);
        this.temperature_hull = (float) (0.1*count);
        if (count==10) count = 0;
        count++;
    }

    public Status(float voltage, float amperage, float charge, float pressure, float humidity, float temperature_cpu, float temperature_hull) {
        this.voltage = voltage;
        this.amperage = amperage;
        this.charge = charge;
        this.pressure = pressure;
        this.humidity = humidity;
        this.temperature_cpu = temperature_cpu;
        this.temperature_hull = temperature_hull;
    }

    public float getVoltage() {
        return voltage;
    }

    public void setVoltage(float voltage) {
        this.voltage = voltage;
    }

    public float getAmperage() {
        return amperage;
    }

    public void setAmperage(float amperage) {
        this.amperage = amperage;
    }

    public float getCharge() {
        return charge;
    }

    public void setCharge(float charge) {
        this.charge = charge;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getTemperature_cpu() {
        return temperature_cpu;
    }

    public void setTemperature_cpu(float temperature_cpu) {
        this.temperature_cpu = temperature_cpu;
    }

    public float getTemperature_hull() {
        return temperature_hull;
    }

    public void setTemperature_hull(float temperature_hull) {
        this.temperature_hull = temperature_hull;
    }
}
