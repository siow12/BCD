package org.example.blockchain;


import org.example.DB;
import org.example.DBSingleton;

import java.util.LinkedList;

public class Blockchain {

    private static DB<Block> db = null;

    static {
        try {
            db = DBSingleton.getDb(Block.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void newBlock(Block block) throws Exception{
        db.getEntityStore().add(block);
        db.save();
    }


    public static LinkedList<Block> getBlocks() throws Exception {
        if(db.getEntityStore().size() == 0){
            Block genesis = new Block("0");
            newBlock(genesis);
        }
        return db.getEntityStore();
    }
}
