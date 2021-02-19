package main

type ParkingSystem struct {
	lots [3]int
}

func Constructor(big int, medium int, small int) ParkingSystem {
	return ParkingSystem{[3]int{big, medium, small}}
}

func (ps *ParkingSystem) AddCar(carType int) bool {
	if ps.lots[carType-1] > 0 {
		ps.lots[carType-1]--
		return true
	}
	return false
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * obj := Constructor(big, medium, small);
 * param_1 := obj.AddCar(carType);
 */