package com.killer.stoyan.labirinth;

public class B extends Room{
    public B(){
        new Room(false,false,true,false,false,false);
    }
    public boolean hasRight(){
        return false;
    }
}
