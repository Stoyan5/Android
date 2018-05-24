package com.killer.stoyan.labirinth;

public class Room {
    boolean top,right,bottom,left,exit,entrance;

    protected Room(){
        this.top=false;
        this.right=false;
        this.bottom=false;
        this.left=false;
        this.exit=false;
        this.entrance=false;
    }
    protected Room( boolean top,boolean right,boolean bottom,boolean left,boolean exit,boolean entrance){
        this.top=top;
        this.right=right;
        this.bottom=bottom;
        this.left=left;
        this.exit=exit;
        this.entrance=entrance;
    }
    public boolean hasRight(){
        return right;
    }
    public boolean hasBottom(){
        return bottom;
    }
    public boolean hasTop(){
        return top;
    }
    public boolean hasLeft(){
        return left;
    }
    public boolean isExit(){
        return exit;
    }
    public boolean isEntrance(){
        return entrance;
    }
}
