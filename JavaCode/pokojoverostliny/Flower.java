package com.pokojoverostliny;

import java.time.LocalDate;

public class Flower {

    private static final String FILE_ITEM_DELIMITER = "\t";

    public String flowerName;
    public String notes;
    public LocalDate planted;
    public LocalDate watering;
    public int frequencyOfWatering;

    public Flower(String flowerName, String notes, LocalDate planted, LocalDate watering, int frequencyOfWatering) {
        this.flowerName = flowerName;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Flower() {
        this.flowerName = this.flowerName;
        this.notes = this.notes;
        this.planted = this.planted;
        this.watering = this.watering;
        this.frequencyOfWatering = this.frequencyOfWatering;
    }

    public Flower(String notes, LocalDate watering) {
        this.notes = "";
        this.watering = LocalDate.now();
    }

    public Flower(String notes, LocalDate watering, int frequencyOfWatering, LocalDate planted) {
        this.notes = "";
        this.watering = LocalDate.now();
        this.frequencyOfWatering = 7;
        this.planted = LocalDate.now();

    }


    public String getFlowerName() {
        return flowerName;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public LocalDate getWatering() {
        return watering;
    }


    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public String getWaterInfo() {
        LocalDate dateOfWatering = watering.plusDays(frequencyOfWatering);
        return flowerName + watering + dateOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException {
        if (frequencyOfWatering <= 0) throw new PlantException("Can not be lower or 0.");
        }


        public void setWatering (LocalDate watering) throws PlantException {
            if (watering.isBefore(planted)) throw new PlantException("Can not be older then planted date.");

        }
    public static Flower parseFlower(String record) throws PlantException {
        String[] items = record.split(FILE_ITEM_DELIMITER);
        int numbersOfItems = items.length;
        if (numbersOfItems != 5) {
            throw new PlantException("You need to fill in 5 fields." + numbersOfItems);
        }

        String flowerName = items[0];
        String notes = items[1];
        LocalDate planted = LocalDate.parse(items[2]);
        LocalDate watering = LocalDate.parse(items[3]);
        int frequencyOfWatering = Integer.parseInt(items[4]);

        return new Flower(
                flowerName,notes,planted, watering,frequencyOfWatering
        );

    }


    public String prepareToWrite() {
        return getFlowerName() + FILE_ITEM_DELIMITER
                + getNotes() + FILE_ITEM_DELIMITER
                + getPlanted() + FILE_ITEM_DELIMITER
                +getWatering() + FILE_ITEM_DELIMITER
                + getFrequencyOfWatering()+ FILE_ITEM_DELIMITER;

    }
    public String newFlowerList() {
        return new Flower() + FILE_ITEM_DELIMITER;

    }


}

