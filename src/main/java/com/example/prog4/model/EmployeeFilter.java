
package com.example.prog4.model;

import com.example.prog4.model.enums.EmployeeSortField;
import com.example.prog4.model.utilities.DateRange;
import com.example.prog4.repository.entity.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

import static org.springframework.data.domain.Sort.Direction.ASC;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeFilter implements Serializable {
    private String firstName = "";
    private String lastName = "";
    private Sex sex;
    private String position = "";
    private String countryCode = "";

    private DateRange entrance = DateRange.builder().build();
    private DateRange departure = DateRange.builder().build();

    private EmployeeSortField orderBy = EmployeeSortField.lastName;
    private Sort.Direction orderDirection = ASC;
    private String page = "1";
    private String perPage = "5";

    public Integer getIntPage() {
        return parseOrDefault(page, 1);
    }

    public Integer getIntPerPage() {
        return parseOrDefault(perPage, 10);
    }

    private Integer parseOrDefault(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}

