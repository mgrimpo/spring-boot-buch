package com.example.managingtransactions;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BookingService {

  private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public BookingService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Transactional
  public void book(String... persons) {
    for (String person : persons) {
      logger.info(String.format("Logging person %s", person));
      jdbcTemplate.update("INSERT INTO bookings (first_name) VALUES (?)", person);
    }
  }

  public List<String> findAllBookings() {
    return jdbcTemplate.query(
        "SELECT first_name FROM bookings",
        (resultSet, rowNumber) -> resultSet.getString("first_name"));
  }
}
