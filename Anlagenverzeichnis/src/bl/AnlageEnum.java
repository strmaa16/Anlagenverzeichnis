package bl;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxi
 */
public enum AnlageEnum
{
   ABSCHREIBUNG("Abschreibung"),
   AK("ak"),
   DATUM("Datum"),
   ND("nd"),
   BISHERND("BisherND"),
   AFA("afa"),
   AFAVORHER("afavorher"),
   AFAJAHR("afajahr"),
   BW("bw");
   
   private String name;

    private AnlageEnum(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
   
}
