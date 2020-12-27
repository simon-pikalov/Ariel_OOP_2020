import concurrent.futures
import threading
import time


def thread_function(myName):
    print("Starting: {:}".format(myName))
    time.sleep(2)
    print("Ending: {:}".format(myName))
    return myName


def basic_thread():
    x = threading.Thread(target=thread_function, args=("MyFirstThread",))
    x.start()


def daemon_thread():
    x = threading.Thread(target=thread_function, args=(str("Demon"),), daemon=True)
    x.start()


def thread_pool():
    with concurrent.futures.ThreadPoolExecutor(max_workers=3) as executor:
        executor.map(thread_function, range(5))


class PesudoDataBase():
    def __init__(self):
        self.value = 0
        self._lock = threading.Lock()

    def update(self, name):
        with self._lock:
            tmp = self.value
            tmp = tmp + 1
            time.sleep(0.01)
            self.value = tmp


def race_demo():
    pdb = PesudoDataBase()
    with concurrent.futures.ThreadPoolExecutor(max_workers=3) as executor:
        for _ in range(10):
            executor.map(pdb.update, range(5))

    print(pdb.value)


def timer_demo():
    def inf_func():
        print("-Dary")

    print("Legen", end='')
    t = threading.Timer(3.0, inf_func)
    t.start()


def main():
    # thread_pool()
    # race_demo()
    timer_demo()


if __name__ == '__main__':
    main()
