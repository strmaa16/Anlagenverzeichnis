package bl;

import data.Anlage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/*
 * @author Maxi
 */
public class AnlagenModel extends AbstractTableModel
{

    public List<Anlage> list = new ArrayList<>();

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

        switch (index)
        {
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

    public void add(Anlage a)
    {

        this.list.add(a);
        this.fireTableDataChanged();

    }

    public void del(int zeile)
    {
        this.list.remove(zeile);
        this.fireTableDataChanged();
    }

    public void laden(File f)
    {
       
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(";");
                String var1 = tokens[0];
                double var2 = Double.parseDouble(tokens[1]);
                LocalDate var3 = LocalDate.parse(tokens[2]);
                double var4 = Double.parseDouble(tokens[3]);
                double var5 = Double.parseDouble(tokens[4]);
                double var6 = Double.parseDouble(tokens[5]);
                double var7 = Double.parseDouble(tokens[6]);
                double var8 = Double.parseDouble(tokens[7]);
                double var9 = Double.parseDouble(tokens[8]);
                Anlage aNeu = new Anlage(var1, var2, var3, var4, var5, var6, var7, var8,var9);
                list.add(aNeu);
                
            }
        }
        catch (FileNotFoundException ex)
        {
             System.err.printf("Es funktionier nicht", ex);
        }
        catch (IOException ex)
        {
            System.err.printf("Es funktionier nicht", ex);
        } 
        
    
     
    }

    public void speichern(File f)
    {
               FileWriter fw = null;
        BufferedWriter bw = null;
        final String COMMA = ";";
        final String LINE = "\r\n";
        try {
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < list.size(); i++) {
                bw.append(list.get(i).getAbschreibung());
                bw.append(COMMA);
                bw.append(list.get(i).getAk()+"");
                bw.append(COMMA);
                bw.append(list.get(i).getDatumAsString());
                bw.append(COMMA);
                bw.append(list.get(i).getNd()+"");
                bw.append(COMMA);
                bw.append(list.get(i).getBisherND()+"");
                bw.append(COMMA);
                bw.append(list.get(i).getAfa()+"");
                bw.append(COMMA);
                bw.append(list.get(i).getAfaVorher()+"");
                bw.append(COMMA);
                bw.append(list.get(i).getAfaJahr()+"");
                bw.append(COMMA);
                bw.append(list.get(i).getBw()+"");
                bw.append(COMMA);
                bw.append(LINE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Fehler beim Schreiben der Datei:" + ex);
        } finally {
            try {
                bw.flush();
                bw.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Fehler beim Schlieï¬‚en der Datei:" + ex);
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
            LocalDate datum = aAlt.getDatum();
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
                    datum = LocalDate.parse((String) o);
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

    public Anlage getAnlageAt(int i)
    {
        return this.list.get(i);
    }

}
