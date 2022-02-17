package pages;

import org.openqa.selenium.By;

public class OLXPage {
	
	private static By txtBuscadorOLX = By.xpath("//input[contains(@placeholder,'Encuentra')]");
	private static By btnBuscadorOLX = By.xpath("//div[@data-aut-id='btnSearch']");
	private static By btnProducto;
	private static By lblProducto;
	
	public static By getBtnProducto() {
		return btnProducto;
	}
	
	public static void setBtnProducto(String producto) {
		OLXPage.btnProducto = By.xpath("//span[contains(text(),'"+producto+"')]//ancestor::a");;
	}
	
	public static By getLblProducto() {
		return lblProducto;
	}
	
	public static void setLblProducto(String producto) {
		OLXPage.lblProducto = By.xpath("//h1[contains(text(),'"+producto+"')]");
	}
	
	public static By getTxtBuscadorOLX() {
		return txtBuscadorOLX;
	}
	
	public static By getBtnBuscadorOLX() {
		return btnBuscadorOLX;
	}	
}
