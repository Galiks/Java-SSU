package com.turchenkov.dao.files;

import com.turchenkov.dao.ItemDAO;
import com.turchenkov.model.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class TxtDao implements ItemDAO {

    private File myFile;

//    private int idCounter;

    private String pathToFile = "E:\\IDEAUltimate\\Projects\\JDBC\\jdbc\\src\\main\\resources\\textFile.txt";

    public TxtDao(String file) {
        ClassLoader classLoader = getClass().getClassLoader();
        this.myFile = new File(Objects.requireNonNull(classLoader.getResource(file)).getFile());
    }

    @Override
    public List<Item> getItems() throws IOException {
        List<Item> itemsOnFile = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) { //need change to universal path
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(":");
                itemsOnFile.add(new Item(words[0], words[1], Integer.parseInt(words[2])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Some gap with IO...");
            e.printStackTrace();
        }
        return itemsOnFile;
    }

    @Override
    public void addItem(Item item) throws IOException {
        try (FileWriter fileWriter = new FileWriter("E:\\IDEAUltimate\\Projects\\JDBC\\jdbc\\file.txt", true)) {
            item.setId(String.valueOf(UUID.randomUUID()));
            fileWriter.write(item.toString());
        } catch (IOException e) {
            System.out.println("Some gap with IO...");
            e.printStackTrace();
        }
    }
}
