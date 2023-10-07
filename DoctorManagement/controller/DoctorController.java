package DoctorManagement.controller;

import java.util.ArrayList;

import DoctorManagement.Repository.DoctorRepository;
import DoctorManagement.model.Doctor;
import DoctorManagement.view.Menu;

public class DoctorController extends Menu {
    DoctorRepository doctorRepository = new DoctorRepository();
    ArrayList<Doctor> doctorList = new ArrayList<>();
    static String[] option = { "Add doctor.",
            "Update doctor.",
            "Delete doctor",
            "Search doctor",
            "Exit" };

    public DoctorController(){
        super("Doctor management program", option);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                doctorRepository.addDoctor(doctorList);
                break;
            case 2:
                doctorRepository.updateDoctor(doctorList);
                break;
            case 3:
                doctorRepository.deleteDoctor(doctorList);
                break;
            case 4:
                doctorRepository.searchDoctor(doctorList);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                break;
        }
    }

}
