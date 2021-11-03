package com.pokojoverostliny;

import java.io.*;
import java.time.LocalDate;

public class Main {

    private static final String INPUT_FILE = "kvetiny.txt";
    private static final String OUTPUT_FILE = "vystup.txt";

    public static void main(String[] args) throws PlantException {

        FlowerList flowerList = new FlowerList();

        flowerList.importFromFile(INPUT_FILE);

        for (int i = 0; i < flowerList.size(); i++) {
            Flower flower = flowerList.getFlower(i);
        }
        try (PrintWriter writer = new PrintWriter(
                new BufferedWriter(new FileWriter(OUTPUT_FILE)))
        ) {

            for (Flower flower : flowerList.data) {
                writer.println(flower.prepareToWrite());
            }
        } catch (IOException e) {
            System.err.println("Error in loading." + OUTPUT_FILE + ":" + e.getLocalizedMessage());
        }


        //add flowers
        System.out.println("Added flowers and their watering:");
        flowerList.addFlower(new Flower("Pampeliska", "zluta", LocalDate.of(2020, 1, 13), LocalDate.of(2020, 2, 13), 5));
        flowerList.addFlower(new Flower("Travicka", "zelena", LocalDate.of(2019, 1, 13), LocalDate.of(2020, 3, 12), 6));
        // remove flowers
        System.out.println("Removed flowers:");
        flowerList.removeFlower(0);

        //final output
        flowerList.exportToFile(OUTPUT_FILE);
        System.out.println("New flowers in output document are added in order:" + " " + "Name of flower and watering:");

        flowerList.importReadFile(OUTPUT_FILE);


    //work with output
        flowerList.importFromFile(OUTPUT_FILE);
        flowerList.addFlower(new Flower("jednu bilou orchidej", "chtel bych ti dat", LocalDate.of(2021, 1, 13), LocalDate.of(2018, 3, 12), 6));
}
}







