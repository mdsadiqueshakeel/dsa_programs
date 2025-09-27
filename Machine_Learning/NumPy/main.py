import numpy as np

output = np.ones((5,5))
print(output)

z = np.zeros((3,3))
z[1,1]=9
z[2,2]=9
print(z)

output[1:-1,1:-1]= z
print(output)

a = np.array([1,2,3])
b = a.copy()
b[0] = 100
print(a)
print(b)