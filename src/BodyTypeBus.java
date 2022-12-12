public enum BodyTypeBus {

    CAPACITY_ES(0, 10),
    CAPACITY_S(11, 25),
    CAPACITY_M(40, 50),
    CAPACITY_B(60, 80),
    CAPACITY_EB(100, 120),
    CAPACITY_ERROR(121);

    private int capacityUp;
    private int capacityDown;

    public int getCapacityUp() {
        return capacityUp;
    }

    public int getCapacityDown() {
        return capacityDown;
    }

    BodyTypeBus(int capacityDown, int capacityUp) {
        this.capacityDown = capacityDown;
        this.capacityUp = capacityUp;
    }

    BodyTypeBus(int capacityDown) {
        this.capacityDown = capacityDown;
    }

    public static BodyTypeBus change(int numberSeats) {
        numberSeats = Math.abs(numberSeats);
        if (numberSeats <= 10) {
            return BodyTypeBus.CAPACITY_ES;
        }
        if (numberSeats <= 25) {
            return BodyTypeBus.CAPACITY_S;
        }
        if (numberSeats <= 50) {
            return BodyTypeBus.CAPACITY_M;
        }
        if (numberSeats <= 80) {
            return BodyTypeBus.CAPACITY_B;
        }
        if (numberSeats <= 120) {
            return BodyTypeBus.CAPACITY_EB;
        }
        return CAPACITY_ERROR;
    }
}
