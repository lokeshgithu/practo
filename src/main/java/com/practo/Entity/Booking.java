package com.practo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookings")
public class Booking {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      private long doctorId;

      private long patientId;

      private String bookingTime;

}
