package com.oocl.cultivation;

public class ParkingBoy {

	private final ParkingLot parkingLot;
	private String lastErrorMessage;

	public ParkingBoy(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public ParkingTicket park(Car car) {
		lastErrorMessage = null;
		return parkingLot.park(car);
	}

	public Car fetch(ParkingTicket ticket) {
		Car car = parkingLot.fetch(ticket);
		if (car == null) {
			lastErrorMessage = "Unrecognized parking ticket.";
		}
		return car;
	}

	public String getLastErrorMessage() {
		
		return lastErrorMessage;
	}
}
