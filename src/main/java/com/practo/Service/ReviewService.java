package com.practo.Service;

import com.practo.Entity.Doctor;
import com.practo.Entity.Patient;
import com.practo.Entity.Review;
import com.practo.Repository.DoctorRepository;
import com.practo.Repository.PatientRepository;
import com.practo.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private ReviewRepository reviewRepo;

    public Review createReview(Review review){

        Doctor doctor = doctorRepo.findById(review.getDoctorId()).get();

        Patient patient = patientRepo.findById(review.getPatientId()).get();

        Review savedReview=null;

        if (doctor!=null || patient!=null){
            savedReview = reviewRepo.save(review);
        }

        return savedReview;
    }

    public List<Review> getReviewByDoctorId(long doctorId){

        List<Review> reviews = reviewRepo.findByDoctorId(doctorId);
        return reviews;
    }

}
