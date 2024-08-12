## encryption using SHA-1 in python

import hashlib 

text = 'Hello There'
result = hashlib.sha1(text.encode())

print("The hexadecimal equivalent of hash using SHA-1 is : \n ", end ="")
print(result.hexdigest())