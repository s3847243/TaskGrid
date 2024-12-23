package com.example.employeeservice.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private String id;
    //@NotNull
    @NotEmpty
    //@NotBlank
    private String name;
    private String surname;
    @Size(min = 10,max = 50)
    @Email
    // @Pattern(regexp = "[a-zA-z0-9]")
    private String email;
    private String job;
    @Min(18)
    @Max(100)
    // @DecimalMin()
    // @DecimalMax()
    @PositiveOrZero
    // @Positive
    // @Negative
    // @NegativeOrZero
    private int age;
    @CreationTimestamp
    private Date addedDate;
    
}
