package com.techelevator.hotels;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import com.techelevator.hotels.services.ConsoleService;
import com.techelevator.hotels.services.HotelService;

public class App {

    private final ConsoleService consoleService = new ConsoleService();
    private final HotelService hotelService = new HotelService();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        int menuSelection = -1;

        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection();
            if (menuSelection == 1) {
                Hotel[] hotels = hotelService.listHotels();
                consoleService.printHotels(hotels);
            } else if (menuSelection == 2) {
                Review[] reviews = hotelService.listReviews();
                for (Review review : reviews) {
                    Hotel hotel = hotelService.getHotelById(review.getHotelId());
                    consoleService.printReview(hotel.getName(), review);
                }
                //consoleService.printReviews(hotelService.listReviews());
            } else if (menuSelection == 3) {
                consoleService.printHotel(hotelService.getHotelById(1));
            } else if (menuSelection == 4) {
                consoleService.printReviews(hotelService.getReviewsByHotelId(1));
            } else if (menuSelection == 5) {
                consoleService.printHotels(hotelService.getHotelsByStarRating(3));
            } else if (menuSelection == 6) {
                System.out.println("Not implemented");
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

}
