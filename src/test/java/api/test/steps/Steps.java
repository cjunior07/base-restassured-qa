package api.test.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import api.test.clients.Clients;

public class Steps {

    Clients clients = new Clients();

    enum Method {
        POST, PATCH, GET
    }

    @Given("I have a payload")
    public void iHaveAPayload() {
        // Step carrega o payload da classe clients
        clients.setPayload();
    }

    @When("I make a {} request to the path {word}")
    public void doRequestPath(Method typeRequest, String path) {
        // Step realiza um switch de acordo com o typeRequest e consome requisição da clients
        switch (typeRequest) {
            case POST:
                clients.postRequest(String.valueOf(typeRequest), path);
                break;
            case PATCH:
                clients.patchRequest(String.valueOf(typeRequest), path);
                break;
            case GET:
                clients.getRequest(String.valueOf(typeRequest), path);
                break;
        }
    }

    @Then("it should return the status code {int}")
    public void returnStatusCode(int statusCode) {
        // Step carrega o método para validar status code da classe clients
        clients.validateStatusCode(statusCode);
    }

    @And("it should return the contract {string}")
    public void returnContract(String schema) {
        // Step carrega o método para validar json schema da classe clients
        clients.validateSchemaApi(schema);
    }
}


