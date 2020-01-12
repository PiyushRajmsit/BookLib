package com.BookLib.Library.model;
public enum BookStatus{

    CURRENT_BOOKS(1),
    WISH_LIST(2),
    FAVOURITES(3),
    NOT_MY_BOOK(4);

    private int value;

    BookStatus(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
    public static BookStatus fromValue(int value){
        switch (value){
            case 1:return BookStatus.CURRENT_BOOKS;
            case 2:return BookStatus.WISH_LIST;
            case 3:return BookStatus.FAVOURITES;
            case 4:return BookStatus.NOT_MY_BOOK;
        }
        return BookStatus.NOT_MY_BOOK;
    }
}
