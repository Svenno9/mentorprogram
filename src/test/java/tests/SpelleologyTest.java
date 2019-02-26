package tests;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

public class SpelleologyTest {

    @Test
    public void itShouldFetchSpells() throws UnirestException {
        int expectedStatus = 200;
        int actualStatus = Unirest.get("https://www.potterapi.com/v1/" + "" +
                "spells?key=$2a$10$f.wBgzvPPpAvJi0D1d1MOOC/uTEqHWqG6tGxfa/i2u.7ob7O9JGla")
                .asJson()
                .getStatus();

        Assert.assertEquals(expectedStatus,actualStatus);
    }
}
