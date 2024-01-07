package com.practo.Controller;

import com.practo.Entity.Doctor;
import com.practo.Entity.Review;
import com.practo.Payload.DoctorDto;
import com.practo.Repository.DoctorRepository;
import com.practo.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review){
        return new ResponseEntity<>(reviewService.createReview(review), HttpStatus.CREATED);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDto> getReviewByDoctorId(@PathVariable long doctorId){
        Doctor doctor = doctorRepository.findById(doctorId).get();
        List<Review> reviews = reviewService.getReviewByDoctorId(doctorId);

        int totalRating = 0;
        for (Review review:reviews){
            totalRating += review.getRating();
        }

        double averageRating = (double) totalRating / reviews.size();
        double ratingPercentage = (averageRating / 5.0) * 100.0;

        DoctorDto dto = new DoctorDto();

        dto.setDoctor(doctor);
        dto.setReviews(reviews);
        dto.setRatingPercentage(ratingPercentage);

        return new ResponseEntity<>(dto, HttpStatus.OK);

    }
}
