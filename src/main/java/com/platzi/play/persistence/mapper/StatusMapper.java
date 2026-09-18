package com.platzi.play.persistence.mapper;

import org.mapstruct.Named;

public class StatusMapper {

    @Named("statusToBoolean")
    public static Boolean statusToBoolean(String status) {
        return switch (status.toUpperCase()) {
            case "D" -> true;
            case "N" -> false;
            default -> throw new IllegalArgumentException("Unknown status: " + status);
        };
    }

    @Named("booleanToStatus")
    public static String booleanToStatus(Boolean status) {
        return status == null ? null : (status ? "D" : "N");
    }
}
