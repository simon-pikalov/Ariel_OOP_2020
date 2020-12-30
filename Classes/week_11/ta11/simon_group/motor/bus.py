from motor.motor_vehicle import MotorVehicle
from motor.public_transfer import PublicTransfer


class Bus(MotorVehicle, PublicTransfer):

    def __init__(self, manufacturer: str = None, model: str = None, registration_plate: str = None,
                 weight: float = None, max_speed: int = None):
        super(MotorVehicle, self).__init__()  # Vehicle
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
        self.passenger_count = 0

    def get_curr_passenger_count(self) -> int:
        return self.passenger_count

    def __add__(self, num: int):
        self.passenger_count += num
        return self

    def __sub__(self, num: int):
        self.passenger_count -= num
        return self

    def __str__(self) -> str:
        return f"str :  manufacturer:{self.manufacturer}, model:{self.model}, registration_plate:{self.registration_plate}, weight:{self.weight}, max_speed:{self.max_speed} , passenger_count :{self.passenger_count} "

    def __repr__(self):
        return f"repr : Bus manufacturer:{self.manufacturer}, model:{self.model}, registration_plate:{self.registration_plate}, weight:{self.weight}, max_speed:{self.max_speed} , passenger_count :{self.passenger_count}"

if __name__ == '__main__':
    volvo9900 = Bus("Volvo", "9900", "656-55-103", 26500, 120)
    print(volvo9900)
    volvo9900 += 16
    print(volvo9900)
