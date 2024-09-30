package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class House {
    private Map<String, Game> games = new HashMap<>();

    /* Step 2 - Instantiating the object calls the constructor */
    public House() {
        /* Step 3a - We create five slot games, five table games and added to map */
        for(int i = 0; i < 5; i++) {
            TableGame tableGame = new TableGame();
            SlotGame slotGame = new SlotGame();
            games.put(tableGame.getId(), tableGame);
            tableGame.setName("Blackjack");
            games.put(slotGame.getId(), slotGame);
            slotGame.setName("Super Slots");
        }
        /* Step 3b - We read the CSV to get the games to put in the map */
        File f = new File("games.csv");
        if (f.exists() && f.isFile()) {
            /* Step 3c - Open file and read each line */
            try (Scanner reader = new Scanner (f)) {
                String lineOfText;
                if(reader.hasNextLine()) {
                    lineOfText = reader.nextLine();
                }
                while (reader.hasNextLine()) {
                    lineOfText = reader.nextLine();
                    String[] strings = lineOfText.split(",");
                    if (strings[1].equalsIgnoreCase("SLOT")) {
                        SlotGame slotGame = new SlotGame(strings[0]);
                        slotGame.setName(strings[2]);
                    } else if (strings[1].equalsIgnoreCase("TABLE")) {
                        TableGame tableGame = new TableGame(strings[0]);
                        tableGame.setName(strings[2]);
                    }
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("Unable to open games.csv");
            }
        } else {
            System.out.println("Unable to open games.csv");
        }
    }

    public void run() {
        /* Step 4 - We loop through map, showing each game of either type */
        for (Map.Entry<String, Game> game : games.entrySet()) {
            System.out.println(game.getKey() + ": " + game.getValue());
        }
    }

    public void saveGames() {
        File f = new File("games.csv");
        try (PrintWriter writer = new PrintWriter(f)) {
            writer.println("GameID,Type,Name,Location,OneChips,FiveChips,TenChips");
            for (Map.Entry<String, Game> gameEntry : games.entrySet()) {
                Game game = gameEntry.getValue();
                writer.print(game.getId() + ",");
                if (game instanceof SlotGame) {
                    writer.print("SLOT,");
                } else if (game instanceof TableGame) {
                    writer.print("Table,");
                } else {
                    writer.print("UNKNOWN,");
                }
                writer.println(game.getName() + "," + game.getLocation() + "," + game.getOneChips() + ",");
                writer.println (game.getFiveChips() + "," + game.getTenChips());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Unable to open games.csv");
    }

    private static int idGeneration = 1;

    public static String generateNewId(String prefix) {
        String generatedId = prefix + idGeneration;
        idGeneration++;
        return generatedId;
    }

}
