package com.unittesting.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record StudentRequest(

        @NotEmpty
        String firstName,

        @NotEmpty
        String lastName,

        @Positive
        int age,

        @Email
        String email,

        @NotEmpty
        Long SchoolId
) {

}
