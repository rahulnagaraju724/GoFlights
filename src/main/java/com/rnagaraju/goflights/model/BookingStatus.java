package com.rnagaraju.goflights.model;

public enum BookingStatus {
    CONFIRMED("Confirmed"),
    PENDING("Pending"),
    CANCELED("Canceled"),
    COMPLETED("Completed"),
    CHECKED_IN("Checked-In"),
    NO_SHOW("No Show"),
    REFUNDED("Refunded"),
    PARTIALLY_REFUNDED("Partially Refunded"),
    PAYMENT_PENDING("Payment Pending");

    private final String status;

    BookingStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }

    // Static method to get BookingStatus from a String
    public static BookingStatus fromString(String status) {
        if (status != null) {
            for (BookingStatus bookingStatus : BookingStatus.values()) {
                if (bookingStatus.getStatus().equalsIgnoreCase(status)) {
                    return bookingStatus;
                }
            }
        }
        throw new IllegalArgumentException("No enum constant for booking status: " + status);
    }
}