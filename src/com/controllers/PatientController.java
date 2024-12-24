package com.controllers;

import java.util.Scanner;

import com.pojo.Patient;
import com.service.PatientServiceImpl;

public class PatientController {
	public static void main(String[] args) {
		PatientServiceImpl pp = new PatientServiceImpl();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 for registration \n Enter 2 to check Entry");
		int n=sc.nextInt();
		do
		{
			switch (n) {
			case 1:
				
				System.out.println("Enter Patients id,name,age,gender");
				Patient p = new Patient(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
				pp.regiter();
				break;
			case 2:
				System.out.println("Enter Patients id");
				Patient p1 = new Patient(sc.nextInt());
				System.out.println(pp.IsRegisted(p1));
				;
				break;
			}
		}while(n!=2);

	}
}
