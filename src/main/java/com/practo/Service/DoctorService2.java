package com.practo.Service;

import com.practo.Entity.Doctor;

import java.util.List;

public interface DoctorService2  {
    Doctor addDoctor(Doctor doctor);
    List<Doctor> searchDoctors(String keyword);
}
