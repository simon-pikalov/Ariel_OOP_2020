from unittest import TestCase

from motor.bus import Bus
from motor.lot import Lot
from motor.motor_vehicle import MotorVehicle


class TesBus(TestCase):



    @classmethod
    def setUpClass(cls):
        print('setupClass')

    @classmethod
    def tearDownClass(cls):
        print('teardownClass')

    def setUp(self):

        self.bus = Bus("Volvo", "9900", "656-55-103", 26500, 120)



    def tearDown(self):
        print('tearDown\n')


    def test_passengers(self):
        self.bus+=10
        self.assertEqual(10,self.bus.passenger_count)
        #self.assertRaises(ValueError,self.bus.__sub__,100) Ugly
        with self.assertRaises(ValueError): # beautiful :)
            self.bus-=100


