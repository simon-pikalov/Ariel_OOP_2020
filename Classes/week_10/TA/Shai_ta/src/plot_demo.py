import numpy as np
import matplotlib.pyplot as plt


def main():
    # Basic Graph
    xs = [1, 22, 33, 44, 55]
    ys = [3, 6, 3, 7, 8]
    plt.plot(ys)
    plt.show()

    plt.plot(xs, ys, '*-r')
    plt.show()

    mat = np.zeros((10,30))
    mat[4:6,5:25] = 1

    plt.matshow(mat)
    plt.show()


if __name__ == '__main__':
    main()
