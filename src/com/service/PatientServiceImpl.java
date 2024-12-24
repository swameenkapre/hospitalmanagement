package com.service;

import com.daolayer.DAO;
import com.pojo.Patient;

public class PatientServiceImpl implements PatientI {

	@Override
	public void regiter() {
		Patient p1=new Patient(1, "Amit", 43, "male");
		DAO.insertPatientD(p1);
	}

	@Override
	public  boolean IsRegisted(Patient p) {
		
		boolean b= DAO.checkId(p.getPid());
		return b;
	}

	@Override
	public void updateDetails() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEntry() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewData() {
		// TODO Auto-generated method stub
		
	}

}
