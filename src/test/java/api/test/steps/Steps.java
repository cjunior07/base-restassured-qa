package api.test.steps;

import api.test.demo.mocks.BodyUser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import api.test.clients.Clients;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static api.test.demo.helpers.HandleGherkin.transform;

public class Steps {

    Clients clients = new Clients();
    RequestSpecification requestSpecification = new RequestSpecBuilder().build();

    enum Method {
        POST, PATCH, GET
    }

    @Given("I have a payload")
    public void iHaveAPayload() {
        clients.setPayload();
    }

    @And("fill in the payload field {word} with the value {string}")
    public void fillPaylodFildsCreateUser(String field, String value) {
        BodyUser payload = new BodyUser();
        if (field.equalsIgnoreCase("name")) {
            payload.setName(transform(value));
        } else if (field.equalsIgnoreCase("job")) {
            payload.setJob(transform(value));
        }
        clients.setPayloadEdited(payload);
    }

    @When("I make a {} request to the path {word}")
    public void doRequestPath(Method typeRequest, String path) {
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
        clients.validateStatusCode(statusCode);
    }

    @And("it should return the contract {string}")
    public void returnContract(String schema) {
        clients.validateSchemaApi(schema);
    }
}


