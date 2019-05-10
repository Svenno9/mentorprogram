package models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("__v")
public class Spell {
    private String id;
    private String spell;
    private String type;
    private String effect;

    @JsonGetter(value = "_id")
    public String getId() {
        return id;
    }

    public String getSpell() {
        return spell;
    }

    public String getType() {
        return type;
    }

    public String getEffect() {
        return effect;
    }
}
