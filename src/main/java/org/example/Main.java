package org.example;

import lombok.Data;

import java.io.Serializable;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        Test t = new Test();
        t.setName("etst");

        var db = DBSingleton.getDb(Test.class);

        db.getEntityStore().add(t);

        db.save();

        System.out.println(db.getEntityStore());


    }
}

@Data
class Test implements Serializable {
    private String name;
}