from unittest import TestCase

from motor.bus import Bus
from motor.lot import Lot
from motor.motor_vehicle import MotorVehicle


class TestLot(TestCase):



    @classmethod
    def setUpClass(cls):
        print('setupClass')

    @classmethod
    def tearDownClass(cls):
        print('teardownClass')

    def setUp(self):
        kia_picanto = MotorVehicle("Kia", "Picanto", "409-94-301", 959, 173)
        shevrolet_spark = MotorVehicle("Chevrolet", "Spark", "479-08-801", 1088, 179)
        hunda_i10 = MotorVehicle("Hyndai", "i10", "548-38-301", 952, 163)
        mitsubishi_SpaceStar = MotorVehicle("Misubushi", "space-star", "000-38-000", 865, 173)
        volvo9900 = Bus("Volvo", "9900", "656-55-103", 26500, 120)
        self.lot = Lot()
        self.lot.add_vehicle(kia_picanto)
        self.lot.add_vehicle(hunda_i10)
        self.lot.add_vehicle(mitsubishi_SpaceStar)
        self.lot.add_vehicle(shevrolet_spark)
        self.lot.add_vehicle(volvo9900)


    def tearDown(self):
        print('tearDown\n')


    def test_save_and_load(self):
        file_name = "lot.json"
        self.lot.save_to_file(file_name)
        loaded_lot = Lot()
        loaded_lot.init_from_file(file_name)
        self.assertEqual(self.lot,loaded_lot)


    def test_remove_vehicle(self):
        license = "409-94-301"
        kia_picanto = self.lot.vehicles.get(license)
        self.lot.remove_vehicle(kia_picanto)
        self.assertIsNone(self.lot.vehicles.get(license))