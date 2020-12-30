import threading
import time
import concurrent.futures

def map_example():
    iterable = [1,2,3,4]
    func = lambda x : x+x
    iterable_res = list(map(func,iterable))
    print(iterable_res)


def heavy_func(seconds):
    print(f"heavy_func sleeping for {seconds}... ")
    time.sleep(seconds)
    return f"heavy_func Done sleeping for {seconds}..."

def simple_thread():
    threads = []
    for i in range(4):
        t = threading.Thread(target=heavy_func,args=[i])
        t.start()
        threads.append(t)
    for t in threads :
        t.join()

def executor_example_thread():
    with concurrent.futures.ThreadPoolExecutor() as executor:
        sleep_time = [i for i in range(6)] # eq of [1,2,3,4,5,6]
        result = executor.map(heavy_func,sleep_time)
        for r in result:
            print(r)

def executor_example_process():
    with concurrent.futures.ThreadPoolExecutor() as executor:
        sleep_time = [i for i in range(6)] # eq of [1,2,3,4,5,6]
        result = executor.map(heavy_func,sleep_time)
        for r in result:
            print(r)


if __name__ == '__main__':
    start = time.perf_counter()
    # simple_thread()
    # map_example()
    # executor_example_thread()
    executor_example_process()
    end = time.perf_counter()
    print(f"Program time {end-start}")