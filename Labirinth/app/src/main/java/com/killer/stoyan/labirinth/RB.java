package com.killer.stoyan.labirinth;

public class RB extends Room{
    public RB(){
        new Room(false,true,true,false,false,false);
    }
    public boolean hasRight(){
        return true;
    }
}
