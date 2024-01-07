package com.practo.Payload;

import com.practo.Entity.Doctor;
import com.practo.Entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

    private Doctor doctor;

    private List<Review> reviews;

    private double ratingPercentage;
}
