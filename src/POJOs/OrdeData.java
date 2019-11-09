
package POJOS;

import java.text.SimpleDateFormat;
import java.util.Comparator;

/**@author María José Galán López */
public class OrdeData implements Comparator <HorasExtras>{
SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public int compare(HorasExtras t, HorasExtras t1) {
       return formato.format(t1.getData()).compareTo(formato.format(t.getData()));
    }
    
}
