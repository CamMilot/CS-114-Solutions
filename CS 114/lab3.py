n = 5

for x in range(1,n):
    prod = 1
    for y in range(1,x):
        prod *= y
    print(prod)


prod1 = 1

for x in range(1,n):
    prod1*=x
    print(prod1)