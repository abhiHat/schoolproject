package com.rosebuds.prasad.schoolproject;

class StudentAdd {
    String name,board,id,studClass;

    public void StudentAdd(){}

    public StudentAdd(String name, String board, String id, String studClass) {
        this.name = name;
        this.board = board;
        this.id = id;
        this.studClass = studClass;
    }

    public String getName() {
        return name;
    }

    public String getBoard() {
        return board;
    }

    public String getId() {
        return id;
    }

    public String getStudClass() {
        return studClass;
    }
}

