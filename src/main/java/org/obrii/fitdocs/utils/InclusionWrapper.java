package org.obrii.fitdocs.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InclusionWrapper {

    private String opening;
    private String openingRegex;

    private String ending;
    private String endingRegex;


    /*
     * Pattern: {someKey}
     * */
    public static InclusionWrapper brackets() {
        return new InclusionWrapper("{", "\\{", "}", "}");
    }

    /*
     * Pattern: ${someKey}
     * */
    public static InclusionWrapper bracketsWithDollar() {
        return new InclusionWrapper("${", "\\$\\{", "}", "}");
    }

    // TODO: test it

    /*
     * Pattern: %someKey%
     * */
    public static InclusionWrapper percents() {
        return new InclusionWrapper("%", "%", "%", "%");
    }

}
