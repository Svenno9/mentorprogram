package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpelleologyPage {
    @FindBy(css = "ul.spells li")
    private WebElement displayedSpells;


}
