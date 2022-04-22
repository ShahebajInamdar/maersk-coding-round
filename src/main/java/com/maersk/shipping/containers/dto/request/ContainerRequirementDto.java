package com.maersk.shipping.containers.dto.request;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class ContainerRequirementDto {
    private ContainerType containerType;
    @Size(min = 5, max = 20)
    private String origin;
    @Size(min = 5, max = 20)
    private String destination;
    @Min(1)
    @Max(100)
    private int quantity;
    private int containerSize;

    public int getContainerSize() {
        return containerSize;
    }

    public void setContainerSize(int containerSize) {
        this.containerSize = containerSize;
    }

    public ContainerType getContainerType() {
        return containerType;
    }

    public void setContainerType(ContainerType containerType) {
        this.containerType = containerType;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
