package culinary.tables;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by olya on 09.02.2017.
 */

@Document(collection = "Family")
public class Family {

    @Id
    private String id;
    @JsonProperty("name")
    private String familyName;

    @JsonProperty("text")
    private String familyText;

    public Family(String name, String text) {
        this.familyName = name;
        this.familyText = text;
    }

    public Family() {}

    public String getFamilyText() {
        return familyText;
    }

    public void setFamilyText(String familyText) {
        this.familyText = familyText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }


}
