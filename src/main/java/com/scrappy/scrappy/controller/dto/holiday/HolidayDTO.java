package com.scrappy.scrappy.controller.dto.holiday;

import lombok.Data;

@Data
public class HolidayDTO {
    private Long id;
    private String date;
    private String name;
    private String type;
    private String description;
}