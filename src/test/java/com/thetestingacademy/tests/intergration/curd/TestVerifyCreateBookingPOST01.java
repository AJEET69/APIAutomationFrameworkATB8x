package com.thetestingacademy.tests.intergration.curd;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.pojos.BookingRespons;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestVerifyCreateBookingPOST01 extends BaseTest {


    @Owner("Ajeet")
    @TmsLink("https://bugz.atlassian.net/jira/software/projects/REQ/boards/1?selectedIssue=REQ-1")
    @Link (name = "Link to TC",url = "https://bugz.atlassian.net/browse/RBT-4")
    @Issue("JIRA_RBT-4")
    @Description
    @Test
    public void verifyCreateBookingPOST01() {

        requestSpecification
                .basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);


                response =
                        RestAssured
                                .given(requestSpecification)
                                .when().body(payloadManager.createPayloadBookingAsString()).post();


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


        // Default Rest Assured - Validation -
        validatableResponse.body("booking.firstname", Matchers.equalTo("James"));

        BookingRespons bookingRespons = payloadManager.bookingResponseJava(response.asString());


        // AssertJ - Validation -

        // assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"James");

        assertThat(bookingRespons.getBookingid()).isNotNull();
        assertThat(bookingRespons.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingRespons.getBooking().getFirstname()).isEqualTo("James");


        // TestNG Assertions
        assertActions.verifyStatusCode(response,200);
        assertActions.verifyResponseBody(bookingRespons.getBooking().getFirstname(),"James","Verify the First Name");

    }


  // for negative Test case
    @Test
    public void testVerifyCreateBookingPOST02() {
    }

    @Test
    public void testVerifyCreateBookingPOST03() {
    }

    @Test
    public void testVerifyCreateBookingPOST04() {
    }

    @Test
    public void testVerifyCreateBookingPOST05() {
    }

    @Test
    public void testVerifyCreateBookingPOST06() {
    }


}
