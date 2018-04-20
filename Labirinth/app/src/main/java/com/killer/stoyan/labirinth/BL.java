package com.killer.stoyan.labirinth;

public class BL extends Room{
    public BL(){
        new Room(false,false,true,true,false,false);
    }
    public boolean hasRight(){
        return false;
    }
}
