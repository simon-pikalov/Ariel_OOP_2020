__author__ = "Simon Pikalov"

import json

from motor_vehicle import MotorVehicle


class Car(MotorVehicle):

    def __init__(self, manufacturer: str = None, model: str = None, registration_plate: str = None,
                 weight: float = 0, max_speed: int = 0, km: int = 0):
        """
        :param manufacturer: The manufacturer of the vehicle.
        :param model: The model of the vehicle .
        :param registration_plate: The registration_plate of the vehicle.
        :param weight: The manufacturer of the vehicle .
        :param max_speed: The max speed  that the vehicle can get.
        """
        super().__init__( manufacturer, model, registration_plate,
                       weight, max_speed)
        self.__km = km



    def __add__(self, other):
        self.__km += other

    def __str__(self) -> str:
        return f"str : MotorVehicle manufacturer:{self.manufacturer}, model:{self.model}, registration_plate:{self.registration_plate}, weight:{self.weight}, max_speed:{self.max_speed},km: {self.__km}"

    def __repr__(self):
        return f"repr : MotorVehicle manufacturer:{self.manufacturer}, model:{self.model}, registration_plate:{self.registration_plate}, weight:{self.weight}, max_speed:{self.max_speed},km: {self.__km}"




if __name__ == '__main__':
    kia_picanto = Car("Kia", "Picanto", "409-94-301", 959, 173)
    shevrolet_spark = Car("Chevrolet", "Spark", "479-08-801", 1088, 179)
    hunda_i10 = Car("Hyndai", "i10", "548-38-301", 952, 163)
    mitsubishi_SpaceStar = Car("Misubushi", "space-star", "000-38-000", 865, 173)

    vehicles = []
    vehicles.append(kia_picanto)
    vehicles.append(shevrolet_spark)
    vehicles.append(hunda_i10)

    print(kia_picanto)
    kia_picanto + 90  # after installing turbo :)
    print(kia_picanto)

    for v in vehicles:
        print(v)
        print(json.dumps(v.encoder_motor_vehicle()))

    print("Unsorted ", vehicles)
    sorted_vehicle_list = sorted(vehicles)
    print("sorted copy  ", sorted_vehicle_list)
    print("The original list is Unsorted ", vehicles)
    vehicles.sort() # im place
    print("sorted in place   ", vehicles)


