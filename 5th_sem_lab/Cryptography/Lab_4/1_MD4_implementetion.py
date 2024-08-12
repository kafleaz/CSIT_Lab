## MD4 implementation using python

import hashlib

text = 'Hello There'
hashObject = hashlib.new('md4', text.encode('utf-8'))
digest = hashObject.hexdigest()

print("The hexadecimal equivalent of hash using MD4 is :\n ", end ="")
print(digest)