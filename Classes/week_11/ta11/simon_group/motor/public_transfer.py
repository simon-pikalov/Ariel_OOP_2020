from abc import ABC, abstractmethod


class PublicTransfer(ABC):
    @abstractmethod
    def get_curr_passenger_count(self) -> int:
        """
        :return: how many  passenger are currently in the public Transfer
        """
        pass

    @abstractmethod
    def __add__(self,num):
        """add passenger to the transfer
        :return: updated number
        """
        pass

    @abstractmethod
    def  __sub__(self,num):
        """minus one passenger to the transfer
        :return: updated number
        """
        pass
