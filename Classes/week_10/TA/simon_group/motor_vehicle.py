import json


class MotorVehicle(object):

    def __init__(self, manufacturer: str = None, model: str = None, registration_plate: str = None,
                 weight: float = None, max_speed: int = None):
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

    def __str__(self) -> str:
        return f"str : MotorVehicle manufacturer:{self.manufacturer}, model:{self.model}, registration_plate:{self.registration_plate}, weight:{self.weight}, max_speed:{self.max_speed}"

    def __repr__(self):
        return f"repr : MotorVehicle manufacturer:{self.manufacturer}, model:{self.model}, registration_plate:{self.registration_plate}, weight:{self.weight}, max_speed:{self.max_speed}"

    def __add__(self, other: int) -> None:
        """
        :param other: the speed to be added
        """
        self.max_speed += other

    def __lt__(self, other):
        return self.max_speed < other.max_speed

    def __eq__(self, o: object) -> bool:
        if isinstance(o, MotorVehicle):
            return self.registration_plate == o.registration_plate  # note that i assume here the that the
            # registration_plate is unique
        return False

    def encoder_motor_vehicle(self):
        return {"manufacturer": self.manufacturer, "model": self.model, "registration_plate": self.registration_plate,
                "weight": self.weight, "max_speed": self.max_speed}


# print("this code will be executed when importing ") # will be printed

if __name__ == '__main__':
    kia_picanto = MotorVehicle("Kia", "Picanto", "409-94-301", 959, 173)
    shevrolet_spark = MotorVehicle("Chevrolet", "Spark", "479-08-801", 1088, 179)
    hunda_i10 = MotorVehicle("Hyndai", "i10", "548-38-301", 952, 163)
    mitsubishi_SpaceStar = MotorVehicle("Misubushi", "space-star", "000-38-000", 865, 173)
    print(kia_picanto==kia_picanto)
    vehicles = []
    vehicles.append(kia_picanto)
    vehicles.append(shevrolet_spark)
    vehicles.append(hunda_i10)

    print(kia_picanto)
    kia_picanto + 90  # after installing turbo :)
    print(kia_picanto)
