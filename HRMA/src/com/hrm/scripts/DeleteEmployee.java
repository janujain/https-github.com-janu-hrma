package com.hrm.scripts;

import generics.Excel;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmpInfoPage;

public class DeleteEmployee extends BaseTest{

	@Test
	public void testDeleteEmployee()
	 {
		 int rc=Excel.getRowCount(INPUT_PATH, "DeleteEmployee");
		 for(int i=1;i<=rc;i++)
		 {
			 String aepURL=Excel.getCellValue(INPUT_PATH, "DeleteEmployee", i, 0);
			 String fn=Excel.getCellValue(INPUT_PATH, "DeleteEmployee", i, 1);
			// String ln=Excel.getCellValue(INPUT_PATH, "DeleteEmployee", i, 2);
			// String updURL=Excel.getCellValue(INPUT_PATH, "DeleteEmployee", i, 3);
		 
		//click on PIM
		DashboardPage dbPage=new DashboardPage(driver);
		dbPage.clickPIM_Menu();
		//verify EMp Info Page
		EmpInfoPage eiPage=new EmpInfoPage(driver);
		eiPage.verifyURLhas(aepURL);
		//select the CB of req emp
		eiPage.clickEmpCheckBox(fn);
		
		//click Delete
		eiPage.clickDelete();
		//click OK
		eiPage.clickOk();
		//verify emp is deleted
		eiPage.verifyEmpIsNotPresent(fn);
	}
}
}
