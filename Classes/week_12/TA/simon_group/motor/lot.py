__author__ = "Simon Pikalov"

import json

from motor.bus import Bus
from motor.motor_vehicle import MotorVehicle


class Lot:

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

    def encoder(self, o): #Same as -> lambda o : o.as_dict
        return o.as_dict()

    def save_to_file(self, file_name:str) -> None:
        """ write data to json format
        :return:None
        """
        try:
            with open(file_name ,"w") as f:
                json.dump(self.vehicles, default=self.encoder,indent=4,fp=f)
        except IOError as e:
            print(e)

    def init_from_file(self,file_name:str)->None:
        new_vehicle_dict = {}
        with open(file_name,"r") as f:
            dict_lot = json.load(f)
            for k,v in dict_lot.items():
                vehicle = MotorVehicle(**v)
                new_vehicle_dict[k] = vehicle
        self.vehicles = new_vehicle_dict

    def __eq__(self, o: object) -> bool:
        if not isinstance(o, Lot):
            # don't attempt to compare against unrelated types
            raise TypeError
        else:
            return self.vehicles == o.vehicles

    def __str__(self) -> str:
        return str(self.vehicles)

    def __iter__(self):
        return self.vehicles.values().__iter__()


def creat_lot():
    kia_picanto = MotorVehicle("Kia", "Picanto", "409-94-301", 959, 173)
    shevrolet_spark = MotorVehicle("Chevrolet", "Spark", "479-08-801", 1088, 179)
    hunda_i10 = MotorVehicle("Hyndai", "i10", "548-38-301", 952, 163)
    mitsubishi_SpaceStar = MotorVehicle("Misubushi", "space-star", "000-38-000", 865, 173)
    volvo9900 = Bus("Volvo", "9900", "656-55-103", 26500, 120)
    my_lot = Lot()
    my_lot.add_vehicle(kia_picanto)
    my_lot.add_vehicle(hunda_i10)
    my_lot.add_vehicle(mitsubishi_SpaceStar)
    my_lot.add_vehicle(shevrolet_spark)
    my_lot.add_vehicle(volvo9900)
    return my_lot


if __name__ == '__main__':
    ariel_lot = creat_lot()
    print(ariel_lot)
    ariel_lot.save_to_file("lot.json")
    new_lot = Lot()
    print(new_lot)
    new_lot.init_from_file("lot.json")
    print(new_lot)


