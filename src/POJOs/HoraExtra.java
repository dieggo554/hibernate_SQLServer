/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package POJOs;

import com.sun.org.apache.bcel.internal.util.Objects;

/**
 *
 * @author usuario
 */
public class HoraExtra{
    //(PK: id) (U: nss data) horas
    private String data;
    private float horas;

    public HoraExtra() {
    }

    public HoraExtra(String data, float horas) {
        this.data = data;
        this.horas = horas;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHoras(float horas) {
        this.horas = horas;
    }

    public String getData() {
        return data;
    }

    public float getHoras() {
        return horas;
    }

    //solucionan errores de comparacion al insertar horas extras
    @Override
    public int hashCode() {
        int hash= 7;
        hash = 97* hash + Objects.hashCode(this.data);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
     if (obj == null){
         return false;
     }   
     if (getClass() != obj.getClass()){
         return false;
     }
     final HoraExtra other = (HoraExtra) obj;
     if (!Objects.equals(this.data, other.data)){
         return false;
     }
     return true;
    }
}
