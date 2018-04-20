package com.killer.stoyan.labirinth;

public class L extends Room{
    public L(){
        new Room(false,false,false,true,false,false);
    }
    public boolean hasRight(){
        return false;
    }
}
