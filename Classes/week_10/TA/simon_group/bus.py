from motor_vehicle import MotorVehicle
from public_transfer import PublicTransfer


class Bus(MotorVehicle, PublicTransfer):

    def __init__(self, manufacturer: str = None, model: str = None, registration_plate: str = None,
                 weight: float = None, max_speed: int = None):

        super(MotorVehicle, self).__init__() # Vehicle
        """
        :param manufacturer: The manufacturer of the vehicle.
        :param model: The model of the vehicle .
        :param registration_plate: The registration_plate of the vehicle.
        :param weight: The manufacturer of the vehicle .
        :param max_speed: The max speed  that the vehicle can get.
        """
        self.manufacturer = manufacturer
        self.model = model
        self.registration_plate = registration_plate
        self.weight = weight
        self.max_speed = max_speed

    def get_curr_passenger_count(self) -> int:
        return  self.passenger_count

    def add_passanger(self) -> int:
        self.passenger_count+=1
        return self.passenger_count

    def get_off_passenger(self) -> int:
        self.passenger_count-=1
        return self.passenger_count



if __name__ == '__main__':
    volvo9900 = Bus("Volvo", "9900", "656-55-103", 26500, 120)
    print(volvo9900)