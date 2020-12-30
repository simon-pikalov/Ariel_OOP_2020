__author__ = "Simon Pikalov"

import json

from motor_vehicle import MotorVehicle


class CarLot:

    def __init__(self):
        self.vehicles = {}
        self.__author__ = "Simon Pikalov"

    def add_vehicle(self, vehicle: MotorVehicle) -> None:
        self.vehicles[vehicle.registration_plate] = vehicle  # add the curr bus

    def remove_vehicle(self, vehicle: MotorVehicle):
        self.vehicles.pop(vehicle.registration_plate)  # remove the curr bus

    def get_fastest_vehicle(self):
        return max(self.vehicles.values(), key=lambda b: b.max_speed)

    def get_all_vehicle(self):
        return self.vehicles

    def encoder(self, o):
        return o.__dict__

    def save_to_file(self, file_name) -> None:
        """ save in json format
        :return:None
        """
        try:
            vehicles_json = json.dumps(self.vehicles, default=self.encoder, indent=4)
            f = open(file_name, "w")
            f.write(vehicles_json)
            f.close()

        except Exception as e:
            print(e)

    def __str__(self) -> str:
        return str(self.vehicles)

    def __iter__(self):
        return self.vehicles.values().__iter__()

if __name__ == '__main__':
    kia_picanto = MotorVehicle("Kia", "Picanto", "409-94-301", 959, 173)
    shevrolet_spark = MotorVehicle("Chevrolet", "Spark", "479-08-801", 1088, 179)
    hunda_i10 = MotorVehicle("Hyndai", "i10", "548-38-301", 952, 163)
    mitsubishi_SpaceStar = MotorVehicle("Misubushi", "space-star", "000-38-000", 865, 173)
    my_lot = CarLot()
    my_lot.add_vehicle(kia_picanto)
    my_lot.add_vehicle(hunda_i10)
    my_lot.add_vehicle(mitsubishi_SpaceStar)
    print(my_lot)
    print(my_lot.get_fastest_vehicle())
    my_lot.save_to_file("lot.json")

    for i in my_lot :
        print(i)
