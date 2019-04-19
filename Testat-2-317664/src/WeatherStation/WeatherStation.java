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
    private double temperature;
    private double windSpeed;
    private double windChillTemp;  
    private int warningCounter;
    private boolean windChanger;
    private boolean temparatureChanger;

    public WeatherStation() 
    {
        this.setWindSpeed(-8);
        this.setTemperature(-15);
        this.setTemparatureChanger(true);
        this.setWindChanger(true);
    }

    private double getTemperature() 
    {
        return temperature;
    }

    private void setTemperature(double ptemperature) 
    {
        this.temperature = ptemperature;
    }

    private double getWindSpeed() 
    {
        return windSpeed;
    }

    private void setWindSpeed(double pwindSpeed) 
    {
        this.windSpeed = pwindSpeed;
    }

    private double getWindChillTemp() 
    {
        return windChillTemp;
    }

    private void setWindChillTemp(double pwindChillTemp) 
    {
        this.windChillTemp = pwindChillTemp;
    }

    private int getWarningCounter() 
    {
        return warningCounter;
    }

    private void setWarningCounter(int pwarningCounter) 
    {
        this.warningCounter = pwarningCounter;
    }

    private boolean isWindChanger() 
    {
        return windChanger;
    }

    private void setWindChanger(boolean pwindChanger) 
    {
        this.windChanger = pwindChanger;
    }

    private boolean isTemparatureChanger() 
    {
        return temparatureChanger;
    }

    private void setTemparatureChanger(boolean ptemparatureChanger) 
    {
        this.temparatureChanger = ptemparatureChanger;
    }

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

    private void calculateWindChillTemperature() 
    {
        this.setWindChillTemp(13.12 + 0.6215 * this.getTemperature() + (0.3965 * this.getTemperature() - 11.37) * (Math.pow(this.getWindSpeed(), 0.16)));
        this.setWindChillTemp(Math.round(this.getWindChillTemp()*10)/10.0);
    }

    private String getMessageWeatherWarning() 
    {
        String message = "";
        if (this.getWindSpeed() >= 70.0 && this.getWindChillTemp() <= -18.0) 
        {
            this.setWarningCounter(this.getWarningCounter()+1);
            message = this.getTemperature() + " C°;" + this.getWindSpeed() + " Km/h; " + this.getWindChillTemp() + " C°; Warning: Storm! ; Warning: Cold! ";
        } else if 
                (this.getWindSpeed() >= 70.0) 
        {
            message = this.getTemperature() + " C°; " + this.getWindSpeed() + " Km/h; " + this.getWindChillTemp() + " C°; Warning: Storm! ";
        } 
        else if (this.getWindChillTemp() <= -18.0) 
        {
            message = this.getTemperature() + " C°;  " + this.getWindSpeed() + " Km/h; " + this.getWindChillTemp() + " C°; Warning: Cold! ";
        } 
        else 
        {
            message = this.getTemperature() + " C°; " + this.getWindSpeed() + " Km/h; " + this.getWindChillTemp() + " C° ";
        }
        return message;
    }
    
    public void output(int pCounter)
    {
        System.out.println("\nThe Weatherstation has collected "+ pCounter+" weather datas:");
        System.out.println("______________________________________________________________ \n");
        for (int i = 0; i < pCounter; i++) 
        {
            this.readTemperature();
            this.readWindSpeed();
            this.calculateWindChillTemperature();
            System.out.println(this.getMessageWeatherWarning());
        }
        System.out.println("\n________________________________________________________________");
        System.out.println("Storm and cold warnings counter: " + this.getWarningCounter());
    }
}
