package com.pokojoverostliny;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FlowerList {

    public ArrayList<Flower> data = new ArrayList<>();


    public void addFlower(Flower flower) {
        data.add(flower);
        System.out.println(flower.getFlowerName() + " " + flower.getWatering() + " . " + "Flower added.");

    }

    public void removeFlower(int index) {
        data.remove(index);
        System.out.println("Flower with index:" + " " + index + " . " + "Is removed.");

    }
    public Flower getFlower(int index) {
        data.get(index);
        return null;
    }

    public int size() {
        return data.size();
    }

    public void clear() {
        data.clear();
    }

    public void importFromFile(String INPUT_FILE) {

        try (Scanner scanner = new Scanner (
                new BufferedReader(new FileReader(INPUT_FILE))
        )
        ){
            while(scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                data.add(Flower.parseFlower(nextLine));
            }

            } catch(
            FileNotFoundException e)

            {
                System.err.println("File :" + INPUT_FILE + "not found!" + e.getLocalizedMessage());
            } catch(
            PlantException e)

            {
                System.err.println("Error in file :" + INPUT_FILE + "not found!" + e.getLocalizedMessage());
            }
        }

    public void exportToFile(String OUTPUT_FILE) {
        try (PrintWriter writer = new PrintWriter(
        new BufferedWriter(
                new FileWriter(OUTPUT_FILE)))
        ) {
            for (Flower flower : data) {
                writer.println(flower.prepareToWrite());
            }
        } catch (IOException e) {
                System.err.println("Error when writing to file" + OUTPUT_FILE + ":" + e.getLocalizedMessage());
            }
        }

        //cteni outputu
    public void importReadFile(String INPUT_FILE) {

        try (Scanner scanner = new Scanner (
                new BufferedReader(new FileReader(INPUT_FILE))
        )
        ){
            while(scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                System.out.println(nextLine);
            }

        } catch(
                FileNotFoundException e)

        {
            System.err.println("File :" + INPUT_FILE + "not found!" + e.getLocalizedMessage());
        }

        }
}





