package com.oocl.cultivation;

public class ParkingBoy {

	private final ParkingLot parkingLot;
	private String lastErrorMessage;

	public ParkingBoy(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public ParkingTicket park(Car car) {
		lastErrorMessage = null;
		if (parkingLot.getAvailableParkingPosition() <= 0) {

			this.lastErrorMessage = "The parking lot is full.";
			return null;
		}

		return parkingLot.park(car);
	}

	public Car fetch(ParkingTicket ticket) {
		Car car = parkingLot.fetch(ticket);
		if (ticket == null) {
			lastErrorMessage = "Please provide your parking ticket.";
			return null;
		}
		if (car == null) {
			lastErrorMessage = "Unrecognized parking ticket.";
		}
		return car;
	}

	public String getLastErrorMessage() {
		return lastErrorMessage;
	}

}
