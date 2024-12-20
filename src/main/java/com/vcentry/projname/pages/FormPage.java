package com.vcentry.projname.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.vcentry.base.BaseClass;

public class FormPage extends BaseClass{
	
	private By prodName=By.id("id0");
	private By mobNum=By.id("id1");
	private By email=By.id("id2");
	private By prodCtg=By.id("id3");
	private By prodQty=By.id("id4");
	private By purName=By.id("id5");
	private By gstNo=By.id("idno");
	private By gstYes=By.id("idyes");
	private By cod=By.id("cod");
	private By netBk=By.id("netbank");
	private By orderBtn=By.id("order");
	private By successMsg=By.xpath("//div[@class='alert alert-success']");
	
	public void enterProdName(String productName) {
		enterText(prodName, productName);
	}
	
	public void enterMobNum(String number) {
		enterText(mobNum, number);
	}
	
	public void enterEmail(String emailId) {
		enterText(email, emailId);
	}
	
	public void selectProdCtg(String ctg) {
		selectByText(prodCtg, ctg);
	}
	
	public void enterProdQty(String quantity) {
		enterText(prodQty, quantity);
	}
	
	public void enterPurNam(String purchaserName) {
		enterText(purName, purchaserName);
	}
	
	public void selectGst(String gst) {
		if(gst.equalsIgnoreCase("Yes")) {
			clickElement(gstYes);
		} else {
			clickElement(gstNo);

		}
	}
	
	public void selectPayment(String payment) {
		if(payment.equalsIgnoreCase("cod")) {
			selectCheckBox(cod);
		}else {
			selectCheckBox(netBk);
		}
	}
	
	public void placeOrder() {
		clickElement(orderBtn);
	}
	public void verifyOrderPlaced(String msg) {
		Assert.assertEquals(getText(successMsg), msg);
	}
}
			