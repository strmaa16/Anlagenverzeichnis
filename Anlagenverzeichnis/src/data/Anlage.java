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
   private final LocalDate datum;
   private final double nd;
   private final double bisherND;
   private final double afa;
   private final double afaVorher;
   private final double afaJahr;
   private final double bw;

   private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
   
    public Anlage(String abschreibung, double ak, LocalDate datum, double nd, double bisherND, double afa, double afaVorher, double afaJahr, double bw)
    {
        this.abschreibung = abschreibung;
        this.ak = ak;
        this.datum = datum;
        this.nd = nd;
        this.bisherND = bisherND;
        this.afa = afa;
        this.afaVorher = afaVorher;
        this.afaJahr = afaJahr;
        this.bw = bw;
    }

    public String getAbschreibung()
    {
        return abschreibung;
    }

    public double getAk()
    {
        return ak;
    }

    public LocalDate getDatum()
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

    public DateTimeFormatter getFormatter()
    {
        return formatter;
    }
    public String getDatumAsString(){
        return datum.format(formatter);
    }
  
    
}
