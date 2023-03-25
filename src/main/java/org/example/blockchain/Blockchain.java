package org.example.blockchain;


import lombok.extern.slf4j.Slf4j;
import org.example.DB;
import org.example.DBSingleton;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class Blockchain {

    private static DB<Block> db = null;

    static {
        try {
            db = DBSingleton.getDb(Block.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void newBlock(Block block){
        db.getEntityStore().add(block);
        db.save();
        log.info("New campaign {} added!!", block.getHeader().getCampaignId());
    }


    public static LinkedList<Block> getBlocks() {
        if (db.getEntityStore().size() == 0) {
            Block genesis = new Block("0");
            newBlock(genesis);
        }
        return db.getEntityStore();
    }

    public static Optional<Block> findBlockByCampaignId(long campaignId ) {
        return db.getEntityStore().stream().filter(b->b.getHeader().getCampaignId()== campaignId).findFirst();
    }


    public static List<Block> findBlockByOrganizer(String organizer) {
        return db.getEntityStore().stream().filter(b->{
            String name = b.getHeader().getOrganizerName();
            return ((name != null) && name.equals(organizer));
        }).toList();
    }



}
