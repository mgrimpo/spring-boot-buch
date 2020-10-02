package com.example.managingtransactions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class AppRunner implements CommandLineRunner {

  private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

  private final BookingService bookingService;

  @Autowired
  public AppRunner(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @Override
  public void run(String... args) throws Exception {
    bookingService.book("John", "Mary", "Tim");
    Assert.isTrue(bookingService.findAllBookings().size() == 3);
    logger.info("John, Mary and Tim have been booked");
    try {
      bookingService.book("Chris", "Samuel");
    } catch (RuntimeException e) {
      logger.info(
          "Chris and Samuel could not be booked, because 'Samuel' does not fit into the db column");
      logger.error(e.getMessage());
    }
    logger.info("The last transaction should have been rolled back completely.");
    logger.info("Currently, these people have been booked:");
    bookingService.findAllBookings().forEach(logger::info);
    try {
      bookingService.book("Holly", null);
    } catch (RuntimeException e) {
      logger.info(
          "This transaction failed too because NULL is not a valid value for this column");
      logger.error(e.getMessage());
    }
    logger.info(
        "Because the last two transactions had to be rolled back, there should only be three people in the bookings table.");
    logger.info("Number of bookings: " + bookingService.findAllBookings().size());
  }
}
