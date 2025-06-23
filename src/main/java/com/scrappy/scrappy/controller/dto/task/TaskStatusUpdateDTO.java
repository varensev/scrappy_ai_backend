package com.scrappy.scrappy.controller.dto.task;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskStatusUpdateDTO {
    @NotBlank(message = "Status is required")
    private String status;
}