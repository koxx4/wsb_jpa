package com.jpacourse.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public final class PatientWithPastVisitsDto {
    private final String firstName;
    private final String lastName;
    private final List<VisitDto> pastVisits;
    private final LocalDate registrationDate;


    public PatientWithPastVisitsDto(String firstName, String lastName, List<VisitDto> pastVisits, LocalDate registrationDate) {
        requireNonNull(firstName, "firstName cannot be null");
        requireNonNull(lastName, "lastName cannot be null");
        requireNonNull(pastVisits, "pastVisits cannot be null");
        requireNonNull(registrationDate, "registrationDate cannot be null");

        this.firstName = firstName;
        this.lastName = lastName;
        this.pastVisits = pastVisits;
        this.registrationDate = registrationDate;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public List<VisitDto> pastVisits() {
        return pastVisits;
    }

    public LocalDate registrationDate() {
        return registrationDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (PatientWithPastVisitsDto) obj;
        return Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName) &&
                Objects.equals(this.pastVisits, that.pastVisits) &&
                Objects.equals(this.registrationDate, that.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, pastVisits, registrationDate);
    }

    @Override
    public String toString() {
        return "PatientWithPastVisitsDto[" +
                "firstName=" + firstName + ", " +
                "lastName=" + lastName + ", " +
                "pastVisits=" + pastVisits + ", " +
                "registrationDate=" + registrationDate + ']';
    }
}


