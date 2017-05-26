package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class ExampleDaoGenerator {
    public static void main(String[] args) throws Exception {

        Schema schema = new Schema(1, "me.redbaby.greendao");




        addNote(schema);


//        new DaoGenerator().generateAll(schema, "/Users/tangqi/android-dev/AndroidStudioProjects/MyGreenDAO/app/src/main/java-gen");
        new DaoGenerator().generateAll(schema, "C:/team/RedBaby/app/src/main/java-gen");
    }

    /**
     * @param schema
     */
    private static void addNote(Schema schema) {

        Entity note = schema.addEntity("Table_shopping");

        note.addIdProperty();
        note.addIntProperty("shopping_id").notNull();
        note.addStringProperty("shopping_name ").notNull();


        note.addFloatProperty("shopping_price").notNull();
        note.addStringProperty("shopping_url");
        note.addStringProperty("shopping_pic");
        note.addIntProperty("shopping_count").notNull();
        note.addIntProperty("shopping_state").notNull();
    }
}




