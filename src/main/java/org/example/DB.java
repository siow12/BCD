package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

@Data
public class DB<T> {

    private static String basePath = "storage/";
    private LinkedList<T> entityStore;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private Class<T> type;


    public DB(Class<T> type) {//Load data into linked list
        File file = getBinaryFile(type);
        if (file.exists()) {
            try (
                    FileInputStream fis = new FileInputStream(file.getPath());
                    ObjectInputStream input = new ObjectInputStream(fis);
            ) {
                this.entityStore = (LinkedList<T>) input.readObject();

            } catch (Exception e) {
                this.entityStore = new LinkedList<>();
            }
        } else {
            this.entityStore = new LinkedList<>();
        }
        this.type = type;
    }

    public void save() {//Save object to binary file
        try {
            mapper.writeValue(getFile(type), this.entityStore);

            //Write binary file
            FileOutputStream fos = new FileOutputStream(getBinaryFile(type).getPath());
            ObjectOutputStream out = new ObjectOutputStream(fos);

            out.writeObject(this.entityStore);
            fos.close();
            out.close();
            System.out.println(getFile(type).getPath() + " Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private File getFile(Class<T> type) throws Exception {//load file based on class name
        File file = Paths.get(basePath + type.getSimpleName() + "Store.json").toFile();
        if (!file.exists()) {
            Files.createDirectories(file.toPath().getParent());
            try {
                //Create file
                FileWriter fw = new FileWriter(file.getPath());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("");
                bw.close();

                return file;
            } catch (Exception e) {
                throw new Exception("File Not Found");
            }
        } else {
            return file;
        }

    }

    private File getBinaryFile(Class<T> type) {//load file based on class name
        File file = Paths.get(basePath + type.getSimpleName() + "Store.bin").toFile();
        if (!file.exists()) {
            try {
                Files.createDirectories(file.toPath().getParent());
                //Create file
                FileWriter fw = new FileWriter(file.getPath());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("");
                bw.close();

                return file;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return file;
        } else {
            return file;
        }

    }
}