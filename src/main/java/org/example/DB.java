package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Data
public class DB<T> {
    private List<T> entityStore;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private Class<T> type;


    public DB(Class<T> type) throws Exception {
        if (getFile(type).exists()) {
            try {
                this.entityStore = mapper.readValue(getFile(type),
                        mapper.getTypeFactory().constructCollectionType(ArrayList.class, type));
            } catch (Exception e) {
                this.entityStore = new ArrayList<>();
            }
        } else {
            this.entityStore = new ArrayList<>();
        }
        this.type = type;
    }

    public void save() throws Exception {
        mapper.writeValue(getFile(type), this.entityStore);
    }

    private File getFile(Class<T> type) throws Exception {
        File file = Paths.get(type.getSimpleName() + "Store.json").toFile();
        if (!file.exists()) {
            try {
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
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
}