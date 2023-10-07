package DoctorManagement.Repository;

import java.util.ArrayList;

import DoctorManagement.model.Doctor;

public interface IDoctorRepository {
    public void addDoctor(ArrayList<Doctor> ld);
    public void updateDoctor(ArrayList<Doctor> ld);
    public void deleteDoctor(ArrayList<Doctor> ld);
    public void searchDoctor(ArrayList<Doctor> ld);
    public Doctor getDoctorByCode(ArrayList<Doctor> ld, String code);
    public ArrayList<Doctor> listFoundByName(ArrayList<Doctor> ld, String name);
}
