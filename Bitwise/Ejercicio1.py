
def distinto(n):
    a = 0;
    for i in n:
        a = a ^ i
    return a

n = [1,3,5,6,6,5,1]
print(distinto(n))