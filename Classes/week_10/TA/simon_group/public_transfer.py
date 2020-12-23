from abc import ABC, abstractmethod


class PublicTransfer(ABC):
    @abstractmethod
    def get_curr_passenger_count(self) -> int:
        """
        :return: how many  passenger are currently in the public Transfer
        """
        pass

    @abstractmethod
    def add_passanger(self) -> int:
        """add passenger to the transfer
        :return: updated number
        """
        pass

    @abstractmethod
    def get_off_passenger(self) -> int:
        """minus one passenger to the transfer
        :return: updated number
        """
        pass


