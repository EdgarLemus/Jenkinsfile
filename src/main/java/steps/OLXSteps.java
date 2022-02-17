package steps;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.By;

import driver.SeleniumWebDriver;
import pages.OLXPage;
import utils.Excel;

public class OLXSteps {
	
	private static ArrayList<Map<String, String>> lecturaExcel = new ArrayList<Map<String,String>>();

	public void escribirEnTexto(By elemento, String texto) {
		boolean validarElemento = false;
		while (validarElemento == false) {
			try {
				SeleniumWebDriver.driver.findElement(elemento).sendKeys(texto);
				validarElemento = true;
			} catch (Exception e) {
				
			}			
		}		
	}

	public void clicEnElemento(By elemento) {
		boolean validarElemento = false;
		while (validarElemento == false) {
			try {
				SeleniumWebDriver.driver.findElement(elemento).click();
				validarElemento = true;
			} catch (Exception e) {
				
			}			
		}		
	}
	
	public String obtenerTextoDeElemento(By elemento) {
		boolean validarElemento = false;
		String textElemento = "";
		while (validarElemento == false) {
			try {
				textElemento = SeleniumWebDriver.driver.findElement(elemento).getText();
				validarElemento = true;
			} catch (Exception e) {
				
			}			
		}
		return textElemento;
	}
	
	public void validarTextoEnPantalla(By elemento, String texto) {
		boolean validarTexto = false;
		if(obtenerTextoDeElemento(elemento).contains(texto)) {
			validarTexto = true;
		}
		assertEquals(true, validarTexto);
	}

	public void buscarProductoEnOLX() {
			try {
				lecturaExcel = Excel.readExcel("C:\\Users\\SOPORTETI\\Documents\\Productos OLX.xlsx", "Hoja1");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for (int i = 0; i < lecturaExcel.size(); i++) {
			escribirEnTexto(OLXPage.getTxtBuscadorOLX(), lecturaExcel.get(i).get("Productos"));
			clicEnElemento(OLXPage.getBtnBuscadorOLX());
			OLXPage.setBtnProducto(lecturaExcel.get(i).get("Productos"));
			clicEnElemento(OLXPage.getBtnProducto());
			OLXPage.setLblProducto(lecturaExcel.get(i).get("Productos"));
			validarTextoEnPantalla(OLXPage.getLblProducto(), lecturaExcel.get(i).get("Productos"));
		}
	}
}
