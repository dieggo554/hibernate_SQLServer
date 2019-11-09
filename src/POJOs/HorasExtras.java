package POJOS;

import java.util.Date;
/** * @author author María José Galán López
 */
public class HorasExtras  implements java.io.Serializable {
     private Date data;
     private float hextras;

    public HorasExtras() {
    }

    public HorasExtras(Date data, float hextras) {
        this.data = data;
        this.hextras = hextras;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getHextras() {
        return hextras;
    }

    public void setHextras(float horasextras) {
        this.hextras = horasextras;
    }

	
    

}


