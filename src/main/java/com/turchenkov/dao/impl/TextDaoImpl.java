package com.turchenkov.dao.impl;

import com.turchenkov.model.BankClient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextDaoImpl {

    private File file;

    public TextDaoImpl(String filePath) {
        this.file = new File(filePath);
    }

    public void write(BankClient client) {
        try (FileWriter writer = new FileWriter(file, true)) { //need change to universal path
            writer.write(client.toString());
        } catch (IOException e) {
            System.out.println("Some gap with IO...");
            e.printStackTrace();
        }
    }

    public List<BankClient> read() {
        List<BankClient> clients = new ArrayList<BankClient>();

        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) { //need change to universal path
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                clients.add(new BankClient(words[1], words[2], Integer.parseInt(words[3]), Integer.parseInt(words[4])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Some gap with IO...");
            e.printStackTrace();
        }

        return clients;
    }
}
