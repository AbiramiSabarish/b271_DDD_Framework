package com.vcentry.testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vcentry.base.BaseClass;
import com.vcentry.projname.pages.FormPage;
import com.vcentry.utils.Function;

public class FormTest extends BaseClass{

	FormPage form;
//    @BeforeClass
//	
//	public void launchurl() {
//		driver.get(Function.getProp("formUrl"));
//		form=new FormPage();
//	}
    
    @BeforeMethod
	public void launchurl() {
		driver.get(Function.getProp("formUrl"));
		form=new FormPage();
	}
    
    @Test(dataProvider="validData")
    public void placeOrder(String product,String mobileNum,String emailId, String Category, String quantity, String Name, String gst, String payment, String message  ) {
    	form.enterProdName(product);
    	form.enterMobNum(mobileNum);
    	form.enterEmail(emailId);
    	form.selectProdCtg(Category);
    	form.enterProdQty(quantity);
    	form.enterPurNam(Name);
    	form.selectGst(gst);
    	form.selectPayment(payment);
    	form.placeOrder();
    	form.verifyOrderPlaced(message);
    }
    
    @DataProvider(name="validData")
    public String[][] validData(){
    	return Function.getTestData("form", "validData");
    }

}
