__author__ = "Simon Pikalov"

import json

from motor.motor_vehicle import MotorVehicle

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





