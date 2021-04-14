package Pizzas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PizzaList {

    public static void main(String[] args) throws FileNotFoundException {

        File pizzaListFile = new File("./MariosPizzabar/Resources/pizza.csv"); //create a reference to the csv file

        Scanner fileScanner = new Scanner(pizzaListFile); // create a scanner with the pizza list file as input

        ArrayList<Pizza> pizzaList = new ArrayList<>();

        //while there is something left to read, continue
        while (fileScanner.hasNext()) {

            String currentString = fileScanner.nextLine(); // a string that holds the current String. We read the file line by line.
            //System.out.println(currentString); // print the current string (currentString) this is a test

            String[] lineAsArray = currentString.split(","); //split currentString using "," as separator indicator

            //create variables for each pizza, assign the from the array and
            int id = tryParse(lineAsArray[0]);
            String name = lineAsArray[1];
            int price = tryParse(lineAsArray[2]);

            Pizza tempPizza = new Pizza(id, name, price); //create Pizza objects from these values.

            pizzaList.add(tempPizza); //Then add them to the arrayList
        }

        //tests
        //System.out.println("Number of pizzas: " + pizzaList.size());
        //System.out.println("The pizza called " + pizzaList.get(0).getName() + " costs " + pizzaList.get(0).getPrice() + " kr.");
        //test: printing out all pizzas in pizza list
        for (Pizza pizza : pizzaList) {
            System.out.println(pizza);
        }


    }

    public static int tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}
