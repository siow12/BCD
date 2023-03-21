package org.example.blockchain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Transaction implements Serializable{

    private final int SIZE = 10;

    List<Object> tranxLst;

    public Transaction() {
        tranxLst = new ArrayList<>( SIZE );
    }

    public List<Object> getTranxLst() {
      return tranxLst;
    }

    public void setTranxLst(List<Object> tranxLst) {
      this.tranxLst = tranxLst;
    }

    //add( String ) : void
    public void add( Object tranx ){
        tranxLst.add(tranx);
    }

    @Override
    public String toString() {
        return "Transaction [tranxLst=" + tranxLst + "]";
    }

}
