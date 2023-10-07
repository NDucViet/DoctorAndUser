package DoctorManagement.DataAccess;

import java.util.ArrayList;

import DoctorManagement.common.Valid;
import DoctorManagement.model.Doctor;

public class FunctionDoctor {
    Valid v = new Valid();
    public void addDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter code: ");
        String code = v.checkInputString();
        //check code exist or not
        if (!v.checkCodeExist(ld, code)) {
            System.err.println("Code exist.");
            return;
        }
        System.out.print("Enter name: ");
        String name = v.checkInputString();
        System.out.print("Enter specialization: ");
        String specialization = v.checkInputString();
        System.out.print("Enter availability: ");
        int availability = v.checkInputInt();
        //check worker duplicate
        if (!v.checkDuplicate(ld, code, name, specialization, availability)) {
            System.err.println("Duplicate.");
            return;
        }
        ld.add(new Doctor(code, name, specialization, availability));
        System.err.println("Add successful.");
    }

    //allow user update doctor
    public void updateDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter code: ");
        String code = v.checkInputString();
        //check code exist or not
        if (v.checkCodeExist(ld, code)) {
            System.err.println("Not found doctor");
            return;
        }
        System.out.print("Enter code: ");
        String codeUpdate = v.checkInputString();
        Doctor doctor = getDoctorByCode(ld, code);
        System.out.print("Enter name: ");
        String name = v.checkInputString();
        System.out.print("Enter specialization: ");
        String specialization = v.checkInputString();
        System.out.print("Enter availability: ");
        int availability = v.checkInputInt();
        //check user change infomation or not
        if (!v.checkChangeInfo(doctor, code, name, specialization, availability)) {
            System.err.println("No change");
            return;
        }
        doctor.setCode(codeUpdate);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.err.println("Update successful");
    }

    //allow user delete doctor
    public void deleteDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter code: ");
        String code = v.checkInputString();
        Doctor doctor = getDoctorByCode(ld, code);
        if (doctor == null) {
            System.err.println("Not found doctor.");
            return;
        } else {
            ld.remove(doctor);
        }
        System.err.println("Delete successful.");
    }

    //allow user search doctor
    public void searchDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter name: ");
        String nameSearch = v.checkInputString();
        ArrayList<Doctor> listFoundByName = listFoundByName(ld, nameSearch);
        if (listFoundByName.isEmpty()) {
            System.err.println("List empty.");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                    "Specialization", "Availability");
            for (Doctor doctor : listFoundByName) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());
            }
        }
    }

    //get docter by code
    public Doctor getDoctorByCode(ArrayList<Doctor> ld, String code) {
        for (Doctor doctor : ld) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    //get list found by name
    public ArrayList<Doctor> listFoundByName(ArrayList<Doctor> ld, String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : ld) {
            if (doctor.getName().contains(name)) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }
}
