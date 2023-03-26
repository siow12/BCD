package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.blockchain.Block;
import org.example.blockchain.Blockchain;
import org.example.blockchain.Transaction;
import org.example.controller.UserController;
import org.example.cryptography.AsymmCryptoService;
import org.example.cryptography.SignatureService;
import org.example.exception.CryptographyException;
import org.example.model.User;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Main {
    //Global UI State
    public static User currentUser;

    //Screens
    public static final LoginPage loginPage = new LoginPage();
    public static final RegisterPage registerPage = new RegisterPage();
    public static final DonorHomepage donorHomePage = new DonorHomepage();
    public static final DonorViewCampaign donorViewCampaign = new DonorViewCampaign();
    public static final Donation donation = new Donation();
    public static final OrganizerHomepage organizerHomePage = new OrganizerHomepage();
    public static final OrganizerAddCampaign organizerAddCampaign = new OrganizerAddCampaign();
    public static final OrganizerViewCampaign organizerViewCampaign = new OrganizerViewCampaign();
    public static final BeneficiaryHomepage beneficiaryHomepage = new BeneficiaryHomepage();
    public static final Statement statementPage = new Statement();
    public static final OrganizerDonatePage organizerDonatePage = new OrganizerDonatePage();

    public static void main(String[] args) throws CryptographyException {



        loginPage.setVisible(true);
//        String test1 = "test";
//        String test2 = AsymmCryptoService.encrypt(test1, "B1");
//        System.out.println(test2);
//        String res = AsymmCryptoService.decrypt(test2, "B1");
//        System.out.println(res);

//        String datatoSign = "test";
//        String signature = SignatureService.sign(datatoSign, "D1");
//        boolean iscorrect = SignatureService.verify(datatoSign, "D1", signature);
//        System.out.println(iscorrect);

        //Register and login
        //UserController.register("YC", "123", User.Role.DONOR);
        //UserController.login("YC","123");
        //System.out.println(currentUser);

        //Create Block
//        Block.Header latestHeader = Blockchain.getBlocks().getLast().getHeader();
//        Block block = new Block(latestHeader.getIndex() + 1,
//                latestHeader.getCurrentHash(),
//                latestHeader.getCampaignId() + 1,
//                new ArrayList<>(List.of(Transaction.builder()
//                                                   .from("yc")
//                                                   .to("ssy")
//                                                   .signature("test")
//                                                   .timestamp(
//                                                           Instant.now().toEpochMilli())
//                                                   .build())));
        //Blockchain.newBlock(block);
//        Blockchain.getBlocks()
//                  .getLast()
//                  .getTransactions()
//                  .add(Transaction.builder()
//                                  .from("yc")
//                                  .to("ssy")
//                                  .signature("test")
//                                  .timestamp(Instant.now().toEpochMilli())
//                                  .build());
//
//        Blockchain.getBlocks().getLast().finalizeHeader();
//
//        System.out.println(Blockchain.getBlocks());
//
//        Blockchain.db.save();

        //Add Transaction
//        List<Object> list = List.of(Test.builder().name("name1").build(), Test2.builder().name("name1").build());
//        System.out.println(list);
//        list.stream().filter(o->o instanceof Test).findFirst().ifPresent(System.out::println);
//
//        List<TestData> list1 = List.of(TestData.builder().value(1).build(),TestData.builder().value(2).build());
//        System.out.println(list1.stream().mapToInt(TestData::getValue).sum());
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Test implements Serializable {
    private String name;
    private Object data;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Test2 implements  Serializable{
    private String name;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class TestData implements Serializable {
    private Integer value;
}
