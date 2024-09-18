package org.example.stage1;

import java.util.Comparator;
import java.util.Objects;

/**
 * Equals & hashCode
 * Comparable
 * Comparator
 */
public class Basic implements Comparable<Basic>{
    int id;
    String name;
    int total;

    public Basic(int i, String name) {
        this.id = i;
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basic basic = (Basic) o;
        return id == basic.id && name.equals(basic.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


    @Override
    public int compareTo(Basic o) {
        if(this.id == o.id && this.name.equals(o.name)){ //можно заменить на equals, но только в данном случае
            return 0;
        }
        int idComp = Integer.compare(this.id, o.id);
        if(idComp != 0){
            return idComp;
        }
        return this.name.compareTo(o.name);
    }

    public Comparator<Basic> getComp(){
        return (o, o2) -> {
            if(o.id == o2.id && o.name.equals(o2.name)){
                return 0;
            }
            int idComp = Integer.compare(o.id, o2.id);
            if(idComp != 0){
                return idComp;
            }
            return o.name.compareTo(o2.name);
        };
    }
}
