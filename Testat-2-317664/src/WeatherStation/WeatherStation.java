/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WeatherStation;

/**
 *
 * @author Cenedikt
 */
public class WeatherStation
{
    /**
     * temperature
     * <br> saves the temperature
     */    
    private double temperature;
    
    /**
     * windSpeed
     * <br> saves windspeed
     */
    private double windSpeed;
    
    /**
     * warningCounter
     * <br> saves the amount of cold and storm warnings
     */
    private int warningCounter;
    
    /**
     * windChanger
     * <br> saves the wind changer to proccead the reading methode
     */
    private boolean windChanger;
    
    /**
     * temparatureChanger
     * <br> saves the temperature changer to proccead the reading methode
     */
    private boolean temparatureChanger;
    
    /**
    * Konstruktor
    *
    * set all values 
    */
    public WeatherStation() 
    {
        this.setWindSpeed(-8);
        this.setTemperature(-15);
        this.setTemparatureChanger(true);
        this.setWindChanger(true);
    }
    
    /**
     * getTemperature
     * @return temperature
     */
    private double getTemperature() 
    {
        return temperature;
    }
    
    /**
     * setTemperature
     * @param ptemperature 
     */
    private void setTemperature(double ptemperature) 
    {
        this.temperature = ptemperature;
    }
    
    /**
     * getWindSpeed
     * @return windSpeed
     */
    private double getWindSpeed() 
    {
        return windSpeed;
    }
    
    /**
     * setWindSpeed
     * @param pwindSpeed 
     */
    private void setWindSpeed(double pwindSpeed) 
    {
        this.windSpeed = pwindSpeed;
    }
    
    /**
     * getWarningCounter
     * @return warningCounter
     */
    private int getWarningCounter() 
    {
        return warningCounter;
    }
    
    /**
     * setWarningCounter
     * @param pwarningCounter 
     */
    private void setWarningCounter(int pwarningCounter) 
    {
        this.warningCounter = pwarningCounter;
    }
    /**
     * isWindChanger
     * @return windChanger
     */
    private boolean isWindChanger() 
    {
        return windChanger;
    }
    
    /**
     * setWindChanger
     * @param pwindChanger 
     */
    private void setWindChanger(boolean pwindChanger) 
    {
        this.windChanger = pwindChanger;
    }
    
    /**
     * isTemparatureChanger
     * @return temparatureChanger
     */
    private boolean isTemparatureChanger() 
    {
        return temparatureChanger;
    }
    
    /**
     * setTemparatureChanger
     * @param ptemparatureChanger 
     */
    private void setTemparatureChanger(boolean ptemparatureChanger) 
    {
        this.temparatureChanger = ptemparatureChanger;
    }
    
    /**
     * readTemperature
     * <br> creats the temperature datas
     * <br>counts between -10 to 30 jumps up in with 5 and down wiht 1
     */
    private void readTemperature() 
    {
        if (this.getTemperature() < 30 && this.isTemparatureChanger() == true) 
        {
            this.setTemperature(this.getTemperature() + 5);
            if (this.getTemperature() == 30) 
            {
                this.setTemparatureChanger(false);
            }
        } 
        else if (this.getTemperature() > -10 && this.isTemparatureChanger() == false) 
        {
            this.setTemperature(this.getTemperature() -1);
            if (this.getTemperature() == -10) 
            {
                this.setTemparatureChanger(true);
            }
        }
    }
    
    /**
     * readWindSpeed
     * <br> creats the windspeed datas
     * <br> counts between 0 to 80 jups up with 8 and down with 16
     */
    private void readWindSpeed() 
    {
        if (this.getWindSpeed() < 80 && this.isWindChanger() == true) 
        {
            this.setWindSpeed(this.getWindSpeed()+8);
            if (this.getWindSpeed() == 80) 
            {
                this.setWindChanger(false);
            }
        } 
        else if (this.getWindSpeed() > 0 && this.isWindChanger() == false) 
        {
            this.setWindSpeed(this.getWindSpeed()-16);
            if (this.getWindSpeed() == 0) 
            {
                this.setWindChanger(true);
            }
        }
    }
    
    /**
     * calculateWindChillTemperature
     * <br> calculates the wind chill temperature
     * <br>
     * @return windChillTemp
     */
    private double calculateWindChillTemperature() 
    {
        double windChillTemp;
        windChillTemp = 13.12 + 0.6215 * this.getTemperature() + (0.3965 * this.getTemperature() - 11.37) * (Math.pow(this.getWindSpeed(), 0.16));
        windChillTemp = (Math.round(windChillTemp * 10) / 10.0);
        return  windChillTemp;
    }
    
    /**
     * getMessageWeatherWarning
     * <br> creats the message output 
     * <br> when windspeed is higher than or equals 70 and the wind chill temperature lower than or equals -18 gives an Storm and cold warning
     * <br> when windspeed is higher than or equals 70 storm warning
     * <br> when wind chill temperature lower than or equals -18 gives an cold warning
     * <br> else no warning at all
     * @return message
     */
    private String getMessageWeatherWarning() 
    {
        String message = "";
        if (this.getWindSpeed() >= 70.0 && this.calculateWindChillTemperature() <= -18.0) 
        {
            this.setWarningCounter(this.getWarningCounter()+1);
            message = this.getTemperature() + " C°;" + this.getWindSpeed() + " Km/h; " + this.calculateWindChillTemperature() + " C°; Warning: Storm! ; Warning: Cold! ";
        } else if 
                (this.getWindSpeed() >= 70.0) 
        {
            message = this.getTemperature() + " C°; " + this.getWindSpeed() + " Km/h; " + this.calculateWindChillTemperature() + " C°; Warning: Storm! ";
        } 
        else if (this.calculateWindChillTemperature() <= -18.0) 
        {
            message = this.getTemperature() + " C°;  " + this.getWindSpeed() + " Km/h; " + this.calculateWindChillTemperature() + " C°; Warning: Cold! ";
        } 
        else 
        {
            message = this.getTemperature() + " C°; " + this.getWindSpeed() + " Km/h; " + this.calculateWindChillTemperature() + " C° ";
        }
        return message;
    }
    
    /**
     * output
     * <br> is the rsult of the class Wheatherstation 
     * @param pCounter 
     */
    public void output(int pCounter)
    {
        System.out.println("\nThe Weatherstation has collected "+ pCounter+" weather datas:");
        System.out.println("______________________________________________________________ \n");
        for (int i = 0; i < pCounter; i++) 
        {
            this.readTemperature();
            this.readWindSpeed();
            this.calculateWindChillTemperature();
            System.out.println("Weather is: "+this.getMessageWeatherWarning());
        }
        System.out.println("\n________________________________________________________________");
        System.out.println("Storm and cold warnings counter: " + this.getWarningCounter());
    }
}
