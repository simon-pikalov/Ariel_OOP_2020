import threading
import time
shared_int = 0


def inc_times(lock, num):
    global shared_int

    for t in range(num):

        with lock:
            if t % (int(num/100)) == 0 :print(threading.currentThread().getName(),": incremented shared_int")
            shared_int+=1
        # same as :
        # lock.acquire()
        # shared_int += 1
        # lock.release()

def main_task(num):
    lock = threading.Lock()
    t1 = threading.Thread(target=inc_times,args=[lock,num] )
    t2 = threading.Thread(target=inc_times,args=[lock,num] )
    t1.start()
    t2.start()
    t1.join()
    t2.join()


if __name__ == '__main__':
    num = 1000000
    start = time.perf_counter()
    main_task(num)
    #inc_times(threading.Lock(),num*2)
    print(shared_int)
    end = time.perf_counter()
    print(f"Program time {end-start}")