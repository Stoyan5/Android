package com.killer.stoyan.labirinth;

public class TRL extends Room{
    public TRL(){
        new Room(true,true,false,true,false,false);
    }
    public boolean hasRight(){
        return true;
    }
}
