/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wetterstation;

import java.util.ArrayList;

/**
 *
 * @author Cenedikt
 */
public class Wetterstation 
{
    private ArrayList<Integer> tempList = new ArrayList<Integer>();
    private ArrayList<Integer> windSpeedList = new ArrayList<Integer>();
    private double windChillTemp;
    private int countWarning;

    /**
     * Konstruktor
     */
    public Wetterstation() 
    {
        tempList.add(-18);
        windSpeedList.add(-8);
    }
    
    /**
     * Zugriff auf zaehlWarnung
     *
     * @return countWarning
     */
    public int getCountWarning() 
    {
        return countWarning;
    }

    /**
     * Temperaturemessung zwischen -10c° bis 30C°
     *
     * @return temperature
     */
//    public double messeTemperatur() 
//    {
//        boolean temparatureCounter= true;
//        if (temperature < 30 && temparatureCounter == true) 
//        {
//            this.temperature += 5;
//            if (temperature == 30) 
//            {
//                temparatureCounter = false;
//            }
//        } 
//        else if (temperature > -10 && temparatureCounter == false) 
//        {
//            this.temperature -= 1;
//            if (temperature == -10) 
//            {
//                temparatureCounter = true;
//            }
//        }
//        return temperature;
//    }

    public void messeWindgeschwindigkeit(int pLoopCounter) 
    {
        boolean windCounter = true;
        int loopCounter=pLoopCounter;
        for (int i=1; i < loopCounter ;i++)
        {
            if (windSpeedList.get(i) < 80 && windCounter == true) 
            {                
                windSpeedList.add(windSpeedList.get(i)+8);
                if (windSpeedList.get(i) == 80) 
                {
                    windCounter = false;
                }
            } 
            else if (windSpeedList.get(i) > 0 && windCounter == false) 
            {
                windSpeedList.add(windSpeedList.get(i)-16);
                if (windSpeedList.get(i)  == 0) 
                {
                    windCounter = true;
                }
            }
        }
    }

    /**
     * Berechne Windchill Temperature
     *
     * @param temperature Übergabe gemessene temperature für die weitere
     * Berechnung
     * @param windGeschwindigkeit Übergabe gemessene Windgeschwindigkeit für die
     * weitere Berechnung
     * @return this.windChillTemp
     */
//    public double berechneWindChillTemperatur(double temperature, double windGeschwindigkeit) 
//    {
//        temperature = this.temperature;
//        windGeschwindigkeit = this.windSpeed;
//        
//        this.windChillTemp = 13.12 + 0.6215 * temperature + (0.3965 * temperature - 11.37) * (Math.pow(windGeschwindigkeit, 0.16));
//        return this.windChillTemp;
//    }

    /**
     * soll gemessene Temperaturen und Windgeschwindigkeiten inkl. möglicher
     * Sturm- oder Kältewarnungen ausgeben
     *
     * @return ausgabe
     */
//    public String erzeugeWetterWarnung() 
//    {
//        double gemesseneTemperature = messeTemperatur();
//        double gemesseneWindGeschwindigkeit = messeWindgeschwindigkeit();

        //Git für die aktuelle Wetterwarnung notwendige windChilltemp wieder
//        berechneWindChillTemperatur(gemesseneTemperature, gemesseneWindGeschwindigkeit);
//
//        String ausgabe = "";
//
//        if (gemesseneWindGeschwindigkeit >= 70.0 && windChillTemp <= -18.0) 
//        {
//            this.countWarning++;
//            ausgabe = gemesseneTemperature + " C°;" + gemesseneWindGeschwindigkeit + " Km/h; " + windChillTemp + " C°; Sturmwarnung und Kältewarnung ";
//        } 
//        else if (gemesseneWindGeschwindigkeit >= 70.0) 
//        {
//            ausgabe = gemesseneTemperature + " C°; " + gemesseneWindGeschwindigkeit + " Km/h; " + windChillTemp + " C°; Sturmwarnung ";
//        } 
//        else if (windChillTemp <= -18.0) 
//        {
//            ausgabe = gemesseneTemperature + " C°;  " + gemesseneWindGeschwindigkeit + " Km/h; " + windChillTemp + " C°; Kältewarnung ";
//        } 
//        else 
//        {
//            ausgabe = gemesseneTemperature + " C°; " + gemesseneWindGeschwindigkeit + " Km/h; " + windChillTemp + " C° ";
//        }
//        return ausgabe;

    public void output(int pLoopCounter)
    {
        messeWindgeschwindigkeit(pLoopCounter);
        windSpeedList.get(0);
        windSpeedList.get(1);
        windSpeedList.get(2);
        windSpeedList.get(3);
    }
}
