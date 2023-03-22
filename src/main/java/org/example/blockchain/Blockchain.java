package org.example.blockchain;


import org.example.DB;
import org.example.DBSingleton;

import java.util.LinkedList;

public class Blockchain {

    public static DB<Block> db = null;

    static {
        try {
            db = DBSingleton.getDb(Block.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void newBlock(Block block) throws Exception {
        if (db.getEntityStore().getLast().getHeader().getCurrentHash() == null)
            throw new Exception("Can't add block, latest block is not finalized");
        db.getEntityStore().add(block);
        db.save();
    }

    public static LinkedList<Block> getBlock() {
        return db.getEntityStore();
    }
}
