package bl;

import data.Anlage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/*
 * @author Maxi
 */
public class AnlagenModel2 extends AbstractTableModel

{

    List<Anlage> list = new ArrayList<>();

    @Override
    public int getRowCount()
    {
        return this.list.size();
    }

    @Override
    public int getColumnCount()
    {
        return AnlageEnum.values().length;
    }

    @Override
    public Object getValueAt(int row, int col)
    {
        Anlage w = list.get(row);
        AnlageEnum index = AnlageEnum.values()[col];
        
        switch(index){
              case ABSCHREIBUNG:
                return w.getAbschreibung();
            case AK:
                return w.getAk();
            case DATUM:
                return w.getDatum();
            case ND:
                return w.getNd();
            case BISHERND:
                return w.getBisherND();
            case AFA:
                return w.getAfa();
            case AFAVORHER:
                return w.getAfaVorher();
            case AFAJAHR:
                return w.getAfaJahr();
            case BW:
                return w.getBw();
            default:
                return "?";
        }
    }

    public void laden(File f)
    {
        FileReader fr = null;
        BufferedReader br = null;
        try
        {

            fr = new FileReader(f);

            br = new BufferedReader(fr);
            String line;

            line = br.readLine();
            line = br.readLine();
            while (line != null)
            {
                
              
                line = line.replace(".","");
               line = line.replace(",",".");
                String[] tokens = line.split(";");
                String var1 = tokens[0];
                String var2 = tokens[1];
                double var2_double = Double.parseDouble(var2);
                double var3 = Double.parseDouble(tokens[2]);
                double var4 = Double.parseDouble(tokens[3]);

                Anlage neu = new Anlage(var1, var2_double, var3, var4);
                list.add(neu);
                line = br.readLine();
                System.out.println("");

            }
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(AnlagenModel2.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(AnlagenModel2.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try
            {
                br.close();
                fr.close();
            }
            catch (IOException ex)
            {
                Logger.getLogger(AnlagenModel2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }
    public void speichern(File f)  {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try{
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            bw.append(AnlageEnum.values()[0]+";"+AnlageEnum.values()[1]+";"+AnlageEnum.values()[2]+";"+AnlageEnum.values()[3]);
            bw.append("\r\n");
            for(Anlage a : list ){
     
                String line = a.getAbschreibung()+";"+a.getAk()+";"+a.getDatum()+";"+a.getNd()+";"+a.getBisherND();
                
                bw.append(line);
                bw.append("\r\n");
                        
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(AnlagenModel2.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try
            {
                bw.close();
                fw.close();
               
            }
            catch (IOException ex)
            {
                Logger.getLogger(AnlagenModel2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    public void setValueAt(Object o, int row, int col)
    {
        if (o instanceof Anlage)
        {
            list.set(row, (Anlage) o);
        }
        else
        {
            Anlage aAlt = list.get(row);

            String abschreibung = aAlt.getAbschreibung();
            double ak = aAlt.getAk();
            double datum = aAlt.getDatum();
            double nd = aAlt.getNd();
            double bisherND = aAlt.getBisherND();
            double afa = aAlt.getAfa();
            double afaVorher = aAlt.getAfaVorher();
            double afaJahr = aAlt.getAfaJahr();
            double bw = aAlt.getBw();

            AnlageEnum index = AnlageEnum.values()[col];

            switch (index)
            {

                case ABSCHREIBUNG:
                    abschreibung = (String) o;
                    break;
                case AK:
                    ak = Double.parseDouble((String) o);
                    break;
                case DATUM:
                    datum = Double.parseDouble((String) o);
                    break;
                case ND:
                    nd = Double.parseDouble((String) o);
                    break;
                case BISHERND:
                    bisherND = Double.parseDouble((String) o);
                    break;
                case AFA:
                    afa = Double.parseDouble((String) o);
                    break;
                case AFAVORHER:
                    afaVorher = Double.parseDouble((String) o);
                    break;
                case AFAJAHR:
                    afaJahr = Double.parseDouble((String) o);
                    break;
                case BW:
                    bw = Double.parseDouble((String) o);
                    break;

            }
            Anlage aNeu = new Anlage(abschreibung, ak, datum, nd, bisherND, afa, afaVorher, afaJahr, bw);
            list.set(row, aNeu);
            this.fireTableDataChanged();

        }
    }

    @Override
    public boolean isCellEditable(int i, int i1)
    {
         return true;
    }

    @Override
    public Class<?> getColumnClass(int i)
    {
        return String.class;
    }

    @Override
    public String getColumnName(int i)
    {
        return AnlageEnum.values()[i].getName();
    }
    

}
