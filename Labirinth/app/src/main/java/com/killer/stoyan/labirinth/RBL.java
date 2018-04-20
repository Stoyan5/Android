package com.killer.stoyan.labirinth;

public class RBL extends Room{
    public RBL(){
        new Room(false,true,true,true,false,false);
    }
    public boolean hasRight(){
        return true;
    }
}
