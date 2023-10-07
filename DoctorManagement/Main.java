package DoctorManagement;

import DoctorManagement.controller.DoctorController;

public class Main {
    public static void main(String[] args) {
        DoctorController doctorController = new DoctorController();
        doctorController.run();
    }
}
