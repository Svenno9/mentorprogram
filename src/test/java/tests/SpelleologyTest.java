package tests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import context.TestBase;
import models.Spell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static utils.UniRestHelper.setObjectMapper;

public class SpelleologyTest extends TestBase {

    @Before
    public void setMapper() {
        setObjectMapper();
    }

    @Test
    public void itShouldDisplayAllTheSpells() throws UnirestException {
        HttpResponse<Spell[]> spellResponse = Unirest.get("https://www.potterapi.com/v1/" + "spells")
                .queryString("key","$2a$10$f.wBgzvPPpAvJi0D1d1MOOC/uTEqHWqG6tGxfa/i2u.7ob7O9JGla")
                .asObject(Spell[].class);
        List<Spell> spellList = Arrays.asList(spellResponse.getBody());

        driver.get("http://localhost/spelleology.php");
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.spells li")));

        List<WebElement> displayedSpellList = driver.findElements(By.cssSelector("ul.spells li"));
        List<String> displayedSpellEffects = displayedSpellList
                .stream()
                .map(webElement -> webElement.getText())
                .collect(Collectors.toList());

        spellList.forEach(spell -> Assert.assertTrue(displayedSpellEffects.contains(spell.getEffect())));

        // create spellplpgy page
        // more readable test
    }
}
