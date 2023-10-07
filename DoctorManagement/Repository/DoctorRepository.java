package DoctorManagement.Repository;

import java.util.ArrayList;

import DoctorManagement.DataAccess.FunctionDoctor;
import DoctorManagement.model.Doctor;

public class DoctorRepository implements IDoctorRepository {

    FunctionDoctor functionDoctor = new FunctionDoctor();

    @Override
    public void addDoctor(ArrayList<Doctor> ld) {
        functionDoctor.addDoctor(ld);
    }

    @Override
    public void updateDoctor(ArrayList<Doctor> ld) {
        functionDoctor.updateDoctor(ld);
    }

    @Override
    public void deleteDoctor(ArrayList<Doctor> ld) {
        functionDoctor.deleteDoctor(ld);
    }

    @Override
    public void searchDoctor(ArrayList<Doctor> ld) {
        functionDoctor.searchDoctor(ld);
    }

    @Override
    public Doctor getDoctorByCode(ArrayList<Doctor> ld, String code) {
        return functionDoctor.getDoctorByCode(ld, code);

    }

    @Override
    public ArrayList<Doctor> listFoundByName(ArrayList<Doctor> ld, String name) {
        return functionDoctor.listFoundByName(ld, name);
    }

}
