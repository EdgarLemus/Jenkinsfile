package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.*;
import driver.SeleniumWebDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Steps;
import steps.OLXSteps;

import java.util.logging.Logger;

public class OLXBuscadorStepDefinitions {
	
	@Steps
	OLXSteps olxSteps = new OLXSteps();
	Actor actor = new Actor("");

	@Given("^que me encuentro en la pagina de OLX con la url (.*)$")
	public void queMeEncuentroEnLaPaginaDeOLXConLaUrlHttpsWwwOlxComCo(String url) {
//		Logger logger = Logger.getLogger("MyLog");
//		SeleniumWebDriver.ChromeWebDriver(url);
	}

	@When("^busco el proudcto en el buscador$")
	public void buscoElProudctoEnElBuscador() {
//		olxSteps.buscarProductoEnOLX();
	}

	@Then("^podre ver el producto en pantalla$")
	public void podreVerElProductoEnPantalla() {
//		Logger logger = Logger.getLogger("MyLog");
//		for(String tag : scenario.getSourceTagNames()){
//			System.out.print("Tag: " + tag);
//			logger.info(tag);
//		}
//		SeleniumWebDriver.driver.quit();
	}

	@After
	public void after(Scenario scenario){
		Logger logger = Logger.getLogger("MyLog");
		System.out.println("sdf5sf46dsf");
		for(String tag : scenario.getSourceTagNames()){
			System.out.print("Tag: " + tag);
			logger.info(tag);
		}
	}
}
