package com.killer.stoyan.labirinth;

public class TR extends Room{
    public TR(){
        new Room(true,true,false,false,false,false);
    }
    public boolean hasRight(){
        return true;
    }
}
