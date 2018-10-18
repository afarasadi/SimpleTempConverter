package com.example.arazth.tempconverterapp.Temperature;

import com.example.arazth.tempconverterapp.R;

public class Unit {

    private double fahrenheit, celcius, reamur, kelvin;

    public double getFahrenheit() {
        return fahrenheit;
    }

    public double getCelcius() {
        return celcius;
    }

    public double getReamur() {
        return reamur;
    }

    public double getKelvin() {
        return kelvin;
    }

    public void convert(String unit, double number) {
        switch (unit) {
            case "Celcius":
                celcius = number;
                reamur = 4 / 5.0 * number;
                kelvin = number + 273;
                fahrenheit = (9 / 5.0 * number) + 32;
                break;
            case "Reamur":
                celcius = 5 / 4.0 * number;
                reamur = number;
                kelvin = celcius + 273;
                fahrenheit = (9 / 5.0 * celcius) + 32;
                break;
            case "Kelvin":
                celcius = number - 273;
                reamur = 4 / 5.0 * celcius;
                kelvin = number;
                fahrenheit = (celcius * 9/5.0) + 32;
                break;
            case "Fahrenheit":
                celcius = (number - 32) * 5 / 9.0;
                reamur = celcius * 4/5.0;
                kelvin = ((number - 32) * 5 / 9.0) + 273;
                fahrenheit = number;
                break;
            default:
                celcius = 0;
                reamur = 0;
                kelvin = 0;
                fahrenheit = 0;
        }


    }
}
