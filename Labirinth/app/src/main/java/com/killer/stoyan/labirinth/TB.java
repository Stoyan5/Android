package com.killer.stoyan.labirinth;

public class TB extends Room{
    public TB(){
        new Room(true,false,true,false,false,false);
    }
    public boolean hasRight(){
        return false;
    }
}
