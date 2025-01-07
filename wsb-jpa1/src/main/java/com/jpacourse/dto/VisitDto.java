package com.jpacourse.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public final class VisitDto {
    private final Long id;
    private final LocalDateTime visitDateTime;
    private final String doctorFirstName;
    private final String doctorLastName;
    private final List<String> treatmentTypes;

    public VisitDto(Long id, LocalDateTime visitDateTime, String doctorFirstName, String doctorLastName, List<String> treatmentTypes) {
        requireNonNull(id, "id cannot be null");
        requireNonNull(doctorFirstName, "doctorFirstName cannot be null");
        requireNonNull(doctorLastName, "doctorLastName cannot be null");
        requireNonNull(visitDateTime, "visitDateTime cannot be null");
        requireNonNull(treatmentTypes, "treatmentTypes cannot be null");

        this.id = id;
        this.visitDateTime = visitDateTime;
        this.doctorFirstName = doctorFirstName;
        this.doctorLastName = doctorLastName;
        this.treatmentTypes = treatmentTypes;
    }

    public Long id() {
        return id;
    }

    public LocalDateTime visitDateTime() {
        return visitDateTime;
    }

    public String doctorFirstName() {
        return doctorFirstName;
    }

    public String doctorLastName() {
        return doctorLastName;
    }

    public List<String> treatmentTypes() {
        return treatmentTypes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (VisitDto) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.visitDateTime, that.visitDateTime) &&
                Objects.equals(this.doctorFirstName, that.doctorFirstName) &&
                Objects.equals(this.doctorLastName, that.doctorLastName) &&
                Objects.equals(this.treatmentTypes, that.treatmentTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, visitDateTime, doctorFirstName, doctorLastName, treatmentTypes);
    }

    @Override
    public String toString() {
        return "VisitDto[" +
                "id=" + id + ", " +
                "visitDateTime=" + visitDateTime + ", " +
                "doctorFirstName=" + doctorFirstName + ", " +
                "doctorLastName=" + doctorLastName + ", " +
                "treatmentTypes=" + treatmentTypes + ']';
    }
}
