package testData;

import models.SavingRequest;

public class SavingRequestsExamples {
    private SavingRequest request1 = new SavingRequest(
            "Batman's Cave Development",
            "24000",
            13,
            "test@test.com"
    );

    private SavingRequest request2 = new SavingRequest(
            "Batman's Cave Development",
            "22",
            2,
            "google@google.com"
    );

    private SavingRequest request3 = new SavingRequest(
            "Batman's Cave Development",
            "333",
            3,
            "itera@itera.com"
    );

    public SavingRequest getRequest1() {
        return request1;
    }

    public SavingRequest getRequest2() {
        return request2;
    }

    public SavingRequest getRequest3() {
        return request3;
    }
}
