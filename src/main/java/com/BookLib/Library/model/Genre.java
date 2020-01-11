package com.BookLib.Library.model;



public enum Genre {

    ROMANCE(1),
    CRIME(2),
    MYSTERY(3),
    BIOGRAPHY(4),
    FANTASY(5),
    EDUCATIONAL(6);

    private int value;

    Genre(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }


    public static Genre fromValue(int value){
        switch (value){
            case 1:return Genre.ROMANCE;
            case 2:return Genre.CRIME;
            case 3:return Genre.MYSTERY;
            case 4:return Genre.BIOGRAPHY;
            case 5:return Genre.FANTASY;
            case 6:return Genre.EDUCATIONAL;
        }
        return Genre.FANTASY;
    }
}
