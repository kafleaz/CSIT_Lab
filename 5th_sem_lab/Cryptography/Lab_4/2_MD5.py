# Python 3 code to demonstrate the  working of MD5 (string - hexadecimal)

import hashlib

# initializing string
str2hash = "Master Kenobi"

result = hashlib.md5(str2hash.encode())

print("The hexadecimal equivalent of hash using MD5 is :\n ", end ="")
print(result.hexdigest())