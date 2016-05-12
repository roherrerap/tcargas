package src;

import java.util.Calendar;

public class Validaciones
{
    public boolean checkPhone (String number)
    {
        if (number.length()!=7 || number.length()!=10)
            return false;
        
        for (int i=0; i<number.length(); i++)
        {
            if (number.charAt(i)<48 || number.charAt(i)>57)
                return false;
        }
        return true;
    }
    
    public boolean checkPlates (String placa)
    {
        if (placa.length()!=6)
            return false;
                    
        for (int i=0; i<3; i++)
        {
            if (placa.charAt(i)<65 || placa.charAt(i)>90 && placa.charAt(i)<97 || placa.charAt(i)>122)
            {
                return false;
            }
        }
        
        for (int i=3; i<6; i++)
        {
            if (placa.charAt(i)<48 || placa.charAt(i)>57)
            {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkName (String name)
    {
        name= name.toUpperCase();
        for (int i=0; i<name.length(); i++)
        {
            if (name.charAt(i)!=165 && (name.charAt(i)<65 || name.charAt(i)>90))
            {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkEmail (String email)
    {
        email= email.toLowerCase();
        for (int i=0; i<email.length(); i++)
        {
            if (email.charAt(i)==64)
            {
                for (int j=i; j<email.length(); j++)
                {
                    if (email.charAt(j)==46)
                    {
                        if (j+3==(email.length()-1))
                        {
                            if (email.charAt(i+1)==99 && email.charAt(i+2)==111 && email.charAt(i+3)==109)
                                return true;
                            else
                                return false;
                        }
                        else
                            return false;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean checkModel (String modelo)
    {
        Calendar fecha= Calendar.getInstance();
        int year = fecha.get(Calendar.YEAR);
        int M= Integer.parseInt(modelo);
        if (M<1900 || M>year+1)
            return false;
        return true;
    }

}