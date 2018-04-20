package com.killer.stoyan.labirinth;

public class TL extends Room{
    public TL(){
        new Room(true,false,false,true,false,false);
    }
    public boolean hasRight(){
        return false;
    }
}
