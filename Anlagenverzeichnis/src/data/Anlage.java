package data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * @author Maxi
 */
public class Anlage 
{
   private final String abschreibung;
   private final double ak;
   private final double datum;
   private final double nd;
   private final double bisherND;
   private final double afa;
   private final double afaVorher;
   private final double afaJahr;
   private final double bw;
   private final double jahr;

   private String formatter = ("yyyy");
   

    public Anlage(String var1, double var2, double var3, double var4) {
        this.abschreibung=var1;
        this.ak = var2;
        this.datum = var3;
        this.nd = var4;
        this.jahr = Double.parseDouble(LocalDate.now().format(DateTimeFormatter.ofPattern(formatter)));
        this.bisherND = berechnenddauer(datum,jahr);
        this.afaJahr=0;
        this.afaVorher=0;
        this.afa=0;
        this.bw=0;
    }

    public Anlage(String abschreibung, double ak, double datum, double nd, double bisherND, double afa, double afaVorher, double afaJahr, double bw) {
        this.abschreibung=abschreibung;
        this.ak = ak;
        this.datum = datum;
        this.nd = nd;
        this.bisherND = bisherND;
        this.afaJahr=afaJahr;
        this.afaVorher=afaVorher;
        this.afa=afa;
        this.bw=bw;
        this.jahr = Double.parseDouble(LocalDate.now().format(DateTimeFormatter.ofPattern(formatter)));
    }

    public String getAbschreibung()
    {
        return abschreibung;
    }

    public double getAk()
    {
        return ak;
    }

    public double getDatum()
    {
        return datum;
    }

    public double getNd()
    {
        return nd;
    }

    public double getBisherND()
    {
        return bisherND;
    }

    public double getAfa()
    {
        return afa;
    }

    public double getAfaVorher()
    {
        return afaVorher;
    }

    public double getAfaJahr()
    {
        return afaJahr;
    }

    public double getBw()
    {
        return bw;
    }

    public String getFormatter()
    {
        return formatter;
    }
    public double berechnenddauer(double d1, double d2){
        return d1-d2;
    }
  
    
}
