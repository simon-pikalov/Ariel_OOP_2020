__author__ = "Simon Pikalov"

class MotorVehicle(object):

    def __init__(self, manufacturer: str = None, model: str = None, registration_plate: str = None,
                 weight: float = None, max_speed: int = None,**kwargs):
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
        self.__author__ = "Simon Pikalov"

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

    def as_dict(self):
        m_dict = self.__dict__
        # print(dir(self))
        try:
            del m_dict["__author__"]
        except Exception as e:
            print(e)
        return m_dict



