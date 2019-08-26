package com.oocl.cultivation;

public class ParkingBoy {

	private ParkingLot parkingLot;

	private ParkingLot[] parkingLots;

	private String lastErrorMessage;

	public ParkingBoy(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
		this.parkingLots = null;
	}

	public ParkingBoy(ParkingLot[] parkingLots) {
		this.parkingLots = parkingLots;
		this.parkingLot = null;
	}

	public ParkingTicket park(Car car) {
		lastErrorMessage = null;
		if(parkingLot == null) {
			for(int i = 0;i<2;i++) {
				if(parkingLots[i].getAvailableParkingPosition() > 0) {
				return	parkingLots[i].park(car);
				}}
				this.lastErrorMessage = "The parking lot is full.";
				return null;
		}else {
			if (parkingLot.getAvailableParkingPosition() <= 0) {
				this.lastErrorMessage = "The parking lot is full.";
				return null;
			}
			return parkingLot.park(car);
		}
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
